package frame;

import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Btnadapter3 implements ActionListener {
	TextField tf;
	TextArea ta;
	Frame f;
	Cpu cpu;
	Btnadapter2 btn;

	public Btnadapter3(TextField tf, TextArea ta, Cpu cpu, Btnadapter2 btn) {// ¼öÁ¤
		this.tf = tf;
		this.ta = ta;
		this.cpu = cpu;
		this.btn = btn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		btn.sl.bg.removeAll();

		tf.setText("");
		ta.setText("");
		cpu.rnd();
		tf.setEditable(true);
		btn.opportunity = 10;
		btn.cnt = 0;
		btn.sl.bg.repaint();
		btn.hp.make_score();
	}

}
