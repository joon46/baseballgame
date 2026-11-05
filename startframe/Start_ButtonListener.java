package startframe;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import frame.Start;
import frame.Start;

public class Start_ButtonListener implements ActionListener {

	BaseFrame frame;

	public Start_ButtonListener(BaseFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;

	}

	JButton level_high = new JButton(new ImageIcon("src/Images/start3.png"));
	JButton level_low = new JButton("LOW");

	@Override
	public void actionPerformed(ActionEvent e) {

		frame.setVisible(false);

		BaseFrame rule = new BaseFrame("Grand Theft Vault");
		JLabel b2 = new JLabel(new ImageIcon("src/Images/b2.png"));
		b2.setBounds(0, 0, 500, 800);

		rule.setBounds(frame.getBounds());
		rule.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(true);
				frame.setBounds(rule.getBounds());
				rule.dispose();
			}
		});

		rule.setVisible(true);

		level_high.setBounds(150, 640, 200, 118);

		level_high.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rule.dispose();
				frame.setVisible(false);
				Start st = new Start(rule.getLocation());
				st.game();
			}
		});

		rule.add(level_high);
		rule.add(b2);

	}
}
