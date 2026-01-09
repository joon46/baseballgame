package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Result2 {
	String s;
	Frame f;
	Rectangle bnd;

	public Result2(String s, Frame f, Rectangle bnd) {
		this.s = s;
		this.f = f;
		this.bnd = bnd;
	}

	public void getResult() {

		f.setVisible(false);

		Frame f2 = new Frame("Grand Theft Vault");
		f2.setBounds(bnd);
		f2.setLayout(null);

		f2.setResizable(false);

		Font font = new Font("", Font.PLAIN, 50);

		JLabel bgimage = new JLabel(new ImageIcon("src/Images/fail.jpg"));
		bgimage.setSize(700, 530);
		bgimage.setLocation(0, 0);

		TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_NONE);
		ta.setForeground(Color.GREEN);
		ta.setBounds(0, 528, 695, 70);
		ta.setBackground(Color.black);
		ta.setFont(font);
		ta.append(" " + s + "!");
		ta.setEditable(false);

		JButton btn4 = new JButton(new ImageIcon("src/Images/exit.png"));

		btn4.setBounds(620, 50, 50, 50);
		btn4.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				f2.dispose();
				f.setVisible(true);
			}
		});
		f2.add(btn4);
		f2.add(bgimage);
		f2.add(ta);

		f2.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		});

		f2.setVisible(true);
	}
}