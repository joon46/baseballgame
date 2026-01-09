package frame;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;

public class Btnadapter2 implements ActionListener {
	private int[] num;
	private TextField tf;
	private TextArea ta;
	int[] cp;
	Frame f;
	JButton btn3;
	JButton btn;

	int correct = 0;
	int miss = 0;
	public int opportunity = 10;
	int cnt = 0;
	ScoreLabel sl;
	HeartPoint hp;

	Btnadapter2(TextField tf, TextArea ta, int[] cp, JButton btn3, Frame f, JButton btn) {
		this.tf = tf;
		this.ta = ta;
		this.cp = cp;
		this.f = f;
		this.btn3 = btn3;
		this.btn = btn;
		sl = new ScoreLabel(correct, miss, f);
		hp = new HeartPoint(opportunity, f);
		hp.make_score();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String[] N = tf.getText().split("");
			num = new int[3];
			for (int i = 0; i < N.length; i++) {
				if (N[0].equals("0")) {
					N[0] = "a";
				}
				num[i] = Integer.parseInt(N[i]);
			}

			ta.append(tf.getText() + "\n");

			ArrayList<Integer> player = new ArrayList<Integer>();
			ArrayList<Integer> cpu = new ArrayList<Integer>();

			for (int i = 0; i < cp.length; i++) {
				player.add(num[i]);
				cpu.add(cp[i]);
			}

			for (int i = 0; i < player.size();) {
				if (cpu.get(i) == player.get(i)) {
					correct++;
					player.remove(i);
					cpu.remove(i);
				} else {
					i++;
				}

			} // 인덱스 제거

			for (int i = 0; i < player.size(); i++) {
				if (cpu.contains(player.get(i))) {
					miss++;
				}
			}

			sl.setting_score(correct, miss);
			sl.make_score();

			opportunity--;

			cnt++;

			ta.append("Correct : " + correct + " || " + " Miss : " + miss + " || " + " life : " + opportunity + "\n");

			hp.setting_score(opportunity);
			hp.hp_update();

			if (opportunity == 0) {
				ta.append("금고를 여는 데 실패했습니다!" + "\n");
				tf.setEditable(false);
				sl.bg.removeAll();
				opportunity = 10;

				Result2 rs = new Result2("금고를 여는데 실패했습니다", f, f.getBounds());
				rs.getResult();

			} else if (correct == 3) {
				ta.append("금고를 여는 데 성공했습니다! 보물을 챙겨 빠르게 도망가세요!" + "\n");
				String msg = cnt + "회 만에 성공했습니다!\n";

				sl.bg.removeAll();
				hp.make_score();

				opportunity = 10;
				btn3.doClick();
				Result result = new Result(msg, f, f.getBounds());
				result.getResult();
				cnt = 0;

			} else {
				ta.append("카운트를 보고 다시 한 번 시도해보세요" + "\n" + "\n");
			}

			correct = 0;
			miss = 0;
			tf.requestFocus();
			tf.setText("");

		} catch (Exception e1) {
			ta.append("100이상의 세 자리 정수를 입력해주세요" + "\n" + "\n");
			e1.printStackTrace();
		}

	}

	public void keyPressed(KeyEvent e) {
		System.out.println("wwww");
		int i = 0;
		i = e.getKeyCode();
		System.out.println(i);
		if (i == KeyEvent.VK_ENTER) {
			System.out.println("wwww");
		}

	}

}
