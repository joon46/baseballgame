package startframe;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StartFrame {

	BaseFrame frame = new BaseFrame("Grand Theft Vault");
	JButton start = new JButton();
	JButton close = new JButton();
	JLabel backgl = new JLabel();

	public StartFrame() {// Ω√¿€√¢ Frame class

		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});

		start.addActionListener(new Start_ButtonListener(frame));

		ImageIcon img = new ImageIcon("src/Images/start2.png");
		start.setIcon(img);
		start.setBounds(160, 600, 200, 118);

		ImageIcon abc = new ImageIcon("src/Images/b1.jpg");
		JLabel def = new JLabel(abc);
		def.setBounds(0, 0, 500, 800);

		ImageIcon img2 = new ImageIcon("src/Images/close.jpg");
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});

		// frame.add(close);
		frame.add(start);
		frame.add(def);

		frame.setVisible(true);

		// TODO Auto-generated constructor stub

		/*
		 * StartFrame <- Start_ButtonListener <- Start <- btnadapter <- btnadapter3 <-
		 * btnadapter2
		 */
	}

}
