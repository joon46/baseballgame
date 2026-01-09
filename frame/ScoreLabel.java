package frame;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ScoreLabel {

	int correct = 0;
	int miss = 0;

	Frame f;
	JLabel bg = new JLabel();

	public ScoreLabel(int correct, int miss, Frame f) {
		this.correct = correct;
		this.miss = miss;
		this.f = f;
		f.add(bg, 0);

	}

	public void setting_score(int correct, int miss) {
		this.correct = correct;
		this.miss = miss;
	}

	public void make_score() {

		bg.removeAll();
		bg.setBounds(25, 25, 200, 100);

		ArrayList<JLabel> cmp = new ArrayList<JLabel>();
		ArrayList<JLabel> cmp2 = new ArrayList<JLabel>();

		for (int i = 0; i < miss; i++) {
			cmp.add(new JLabel(new ImageIcon("src/Images/miss.png")));
			cmp.get(i).setBounds(35 + i * 30, 73, 25, 25);
			bg.add(cmp.get(i));
		}

		for (int i = 0; i < correct; i++) {
			cmp2.add(new JLabel(new ImageIcon("src/Images/correct.png")));
			cmp2.get(i).setBounds(35 + i * 30, 38, 25, 25);
			bg.add(cmp2.get(i));
		}

		f.repaint();
	}

}
