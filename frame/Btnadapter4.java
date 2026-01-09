package frame;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Btnadapter4 implements ActionListener {

	JButton btn;
	TextField tf;

	public Btnadapter4(JButton btn, TextField tf) {
		// TODO Auto-generated constructor stub
		this.btn = btn;
		this.tf = tf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (tf.getText().length() == 3) {
			btn.doClick();
		}
	}
}
