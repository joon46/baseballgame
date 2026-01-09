package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Player {

	int strike = 0;
	int ball = 0;
	int out = 0;
	// S/B/O을 담을 변수

	int[] num;// Player가 정할 숫자를 담을 변수

	public Player(int i) {
		num = new int[i];
	}

	public void readNum(/*String cpu*/) {//입력용 메서드
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//bufferReader 대신 Textfield에서 받아온 배열을 대신 넣어줄 예정
		try {
			String[] N = br.readLine().split("");//String값을 하나씩 나누고 int값으로 변환하는 과정
			
			for (int i = 0; i < N.length; i++) {
				num[i] = Integer.parseInt(N[i]);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean compareNum(int cp[]) {// 실제 비교구문

		ArrayList<Integer> player = new ArrayList<Integer>();
		ArrayList<Integer> cpu = new ArrayList<Integer>();
		// cpu와 player의 숫자를 임시로 담을 리스트

		for (int i = 0; i < cp.length; i++) {
			player.add(num[i]);
			cpu.add(cp[i]);
		}

		for (int i = 0; i < player.size();) {
			if (cpu.get(i) == player.get(i)) {// 동일 인덱스의 값이 동일하면 ball을 +1하고 리스트에서 제거
				ball++;
				player.remove(i);
				cpu.remove(i);
			} else {// 리스트에서 제거되면 index가 한칸 씩 땡겨짐으로 제거안할때만 i++
				i++;
			}
		}

		for (int i = 0; i < player.size(); i++) {
			if (cpu.contains(player.get(i))) {//i 인덱스의 player값이 cpu에 포함되어 있으면  strike 
				strike++;
			}
		}

		//index와 숫자 둘다 안맞을 경우 ??
		
		if (strike == 3) {
			strike =0;
			out++;
		}

		if (out == 3) {
			System.out.println("3OUT!!! 삼진!");
			return true;
		}

		if (ball == 3) {
			System.out.println("정답입니다~!!");
			return true;
		}

		for (int i = 0; i < cp.length; i++) {
			System.out.print(cp[i]);
		}

		System.out.println();
		System.out.printf("Strike : %d, Ball: %d, Out : %d\n", strike, ball, out);
		ball = 0;

		return false;
	}

}

