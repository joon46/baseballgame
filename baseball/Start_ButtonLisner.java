package baseball;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;

public class Start_ButtonLisner implements ActionListener {

	BaseFrame frame;

	public Start_ButtonLisner(BaseFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;

	}

	JButton level_high = new JButton("HIGH");
	JButton level_low = new JButton("LOW");

	@Override
	public void actionPerformed(ActionEvent e) {

		frame.setVisible(false);

		BaseFrame rule = new BaseFrame("∑Í º≥∏Ì√¢");
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

		level_high.setBounds(75, 260, 100, 59);

		level_high.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rule.dispose();
				frame.setVisible(false);
			}
		});

		rule.add(level_high);

	}
}
