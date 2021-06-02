package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/*
 *  문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오
 		컴퓨터의 숫자는 난수를 이용하여 구한다.
 		(스트라이크는 s, 볼의 B로 나타낸다.
 *
 */
public class BaseballTest {
	public static void main(String[] args) {
		HashSet<Integer> gameNum = new HashSet<Integer>();

		while (gameNum.size() < 3) {
			gameNum.add(new Random().nextInt(10));
		}

		ArrayList<Integer> game = new ArrayList<Integer>(gameNum);
		Collections.shuffle(game);

		int count = 0;
		while (true) {
			Scanner scan = new Scanner(System.in);
			ArrayList<Integer> userNum = new ArrayList<Integer>();
			System.out.println("예상 숫자를 입력해주세요");
			while (userNum.size() < 3) {
				userNum.add(scan.nextInt());
			}

			// 만약 숫자가 있지만 자리가 다르면 B, 숫자도 존재하고 자리도 같다면 S, 아예 존재하지 않는다면 O
			// game의 값과 user의 값을 하나씩 꺼내와서 비교

			int strike = 0;
			int ball = 0;
			for (int i = 0; i < game.size(); i++) {
				for (int j = 0; j < userNum.size(); j++) {
					if (game.get(i) == userNum.get(j) && i == j) {
						strike++;
					} else if (game.get(i) == userNum.get(j) && i != j) {
						ball++;
					}
				}
			}
			System.out.println(strike + "S " + ball + "B ");
			for (int i = 0; i < userNum.size(); i++) {
				userNum.remove(i);
			}
			if (strike == 3) {
				System.out.println("정답입니다.!!");
				System.out.print("정답 : ");
				for (Integer integer : gameNum) {
					System.out.print(integer + ", ");
				}
				System.out.println("\n당신은 " + count + "번 째만에 맞추셨습니다.");
				break;
			}
			count++;
		}
	}

}
