package frame;

import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class HeartPoint {

	Frame f;
	JLabel bg = new JLabel();
	int op = 0;

	ArrayList<JLabel> hp;

	public HeartPoint(int op, Frame f) {
		this.op = op;
		this.f = f;
		f.add(bg, 0);
	}

	public void setting_score(int op) {
		this.op = op;
	}

	public void make_score() {

		bg.removeAll();
		bg.setBounds(300, 500, 400, 100);

		hp = new ArrayList<JLabel>();

		for (int i = 0; i < 10; i++) {
			hp.add(new JLabel(new ImageIcon("src/Images/heart.png")));
			hp.get(i).setBounds(360 - i * 30, 50, 25, 25);
			bg.add(hp.get(i));
		}

		f.repaint();
	}

	public void hp_update() {

		for (int i = 0; i < 10 - op; i++) {
			bg.remove(hp.get(9 - i));
		}

		f.repaint();
	}

}
