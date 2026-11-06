package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Start {

    private Point p;

    public Start(Point p) {
        this.p = p;
    }

    // 클래스 로더를 통한 안전한 이미지 로딩 메서드 (CWE-426 조치)
    private ImageIcon getSafeImageIcon(String path) {
        URL imgUrl = getClass().getResource(path);
        if (imgUrl != null) {
            return new ImageIcon(imgUrl);
        }
        return new ImageIcon(); // 이미지 없을 경우 기본 객체 반환 (NullPointerException 방지)
    }

    public void game() {
        Frame f = new Frame("Grand Theft Vault");
        f.setBounds(700, 100, 700, 600);
        f.setLocation(p);
        f.setLayout(null);
        f.setResizable(false);

        // 안전한 리소스 경로 로딩
        JLabel mainbg = new JLabel(getSafeImageIcon("/Images/main.png"));
        mainbg.setBounds(0, 0, 700, 600);

        JLabel scorebg = new JLabel(getSafeImageIcon("/Images/scoretemp.png"));
        scorebg.setBounds(15, 40, 150, 100);

        Font font = new Font("", Font.PLAIN, 13);
        Font font2 = new Font("", Font.PLAIN, 37);
        
        TextField tf = new TextField();
        tf.setBackground(Color.black);
        tf.setForeground(Color.green);
        tf.setBounds(507, 275, 100, 50);
        tf.setFont(font2);

        JButton btn = new JButton(getSafeImageIcon("/Images/check.jpg"));
        btn.setBounds(615, 275, 50, 50);
        btn.setEnabled(false);

        TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        ta.setBounds(20, 270, 260, 300);
        ta.setFont(font);
        ta.setEditable(false);
        tf.addTextListener(new Btnadapter(tf, btn));

        Cpu cpu01 = new Cpu(3);
        cpu01.rnd();

        JButton btn3 = new JButton(getSafeImageIcon("/Images/reset.jpg"));
        Btnadapter2 bat2 = new Btnadapter2(tf, ta, cpu01.getNum(), btn3, f, btn);
        btn3.setBounds(560, 50, 50, 50);
        btn3.addActionListener(new Btnadapter3(tf, ta, cpu01, bat2));

        JButton btn4 = new JButton(getSafeImageIcon("/Images/exit.png"));
        btn4.setBounds(625, 50, 50, 50);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose(); // 안전한 단일 프레임 자원 해제
            }
        });

        btn.addActionListener(bat2);
        tf.addActionListener(new Btnadapter4(btn, tf));

        f.add(scorebg);
        f.add(tf);
        f.add(btn);
        f.add(ta);
        f.add(btn3);
        f.add(btn4);
        f.add(mainbg);

        // ⭕ 개선: System.exit(0) 대신 프레임 dispose 처리 (CWE-382 조치)
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                f.dispose();
            }
        });
        f.setVisible(true);
    }
}
		f.setVisible(true);
	}

}
