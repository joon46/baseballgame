package frame;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.JButton;

public class Btnadapter implements TextListener {

	private TextField tf;
	private JButton btn_input;
	String temp = "";

	public Btnadapter(TextField tf, JButton btn_input) {
		this.tf = tf;
		this.btn_input = btn_input;
	}

	@Override
	public void textValueChanged(TextEvent e) {// ¼öÁ¤

		if (tf.getText().length() != 3) {
			btn_input.setEnabled(false);
		} else {
			btn_input.setEnabled(true);
		}

		if (tf.getText().length() >= 4) {
			tf.setText(temp);
		}
		temp = tf.getText();
	}

}
