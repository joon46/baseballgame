package baseball;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class StartFrame {

	BaseFrame frame = new BaseFrame("시작 화면");
	JButton start = new JButton();
	JButton close = new JButton();
	JLabel backgl = new JLabel();

	public StartFrame() {

		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});

		start.addActionListener(new Start_ButtonLisner(frame));

		ImageIcon img = new ImageIcon("src/Images/start.png");
		start.setIcon(img);
		start.setBounds(75, 260, 100, 59);

		ImageIcon img2 = new ImageIcon("src/Images/close.jpg");
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});

		close.setIcon(img2);
		close.setBounds(75, 320, 100, 50);

		// frame.add(close);
		frame.add(start);

		frame.setVisible(true);
		// TODO Auto-generated constructor stub

	}

}
