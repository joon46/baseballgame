package frame;

import java.util.Random;

public class Cpu {
	private int num[];

	public Cpu(int i) {
		// TODO Auto-generated constructor stub
		num = new int[i];
	}

	public void rnd() {
		Random rd = new Random();

		for (int i = 0; i < num.length; i++) {
			if (i == 0) {
				num[i] = rd.nextInt(9) + 1;
			} else {
				num[i] = rd.nextInt(10);
			}
		}
	}

	public int[] getNum() {
		return num;
	}

	public void setNum(int[] num) {
		this.num = num;
	}

}