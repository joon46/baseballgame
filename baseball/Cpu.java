package baseball;

import java.util.Random;

public class Cpu {// 컴퓨터의 정보를 담을 class

	private int num[];// 컴퓨터가 정한 i자리 숫자 배열

	public Cpu(int i) {// 생성자
		// TODO Auto-generated constructor stub
		num = new int[i];
	}

	public void rnd() {// 랜덤숫자 만들기
		Random rd = new Random();

		for (int i = 0; i < num.length; i++) {// 첫째 자리는 1~9까지
			if (i == 0) {
				num[i] = rd.nextInt(9) + 1;
			} else {
				num[i] = rd.nextInt(10);
			}
		}
	}

	public int[] getNum() {// getter, setter
		return num;
	}

	public void setNum(int[] num) {
		this.num = num;
	}

}
