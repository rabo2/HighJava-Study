package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Lotto {

	public static void main(String[] args) {
		do {
			switch (mainPage()) {
			case 1:
				int money = announce();
				lottoBuy(money);
				break;
			case 2:
				exit();
				break;
			}
		} while (true);
	}

	public static int mainPage() {
		System.out.println("==========================");
		System.out.println("Lotto 프로그램");
		System.out.println("--------------------------");
		System.out.println("1. Lotto 구입");
		System.out.println("2. 프로그램 종료");
		System.out.println("==========================	");
		System.out.print("메뉴선택 : ");
		return scan();
	}

	public static int scan() {
		return new Scanner(System.in).nextInt();
	}

	public static int announce() {
		System.out.println("Lotto 구입 시작");
		System.out.println("(1000원에 로또번호 하나입니다.)");
		System.out.print("금액 입력 : ");
		int money = scan();
		return money;
	}

	public static void lottoBuy(int money) {
		if (money < 1000) {
			System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!\n");
		} else if (money > 100000) {
			System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!\n");
		} else {
			int count = money / 1000;
			System.out.println("행운의 로또번호는 아래와 같습니다.");
			Set<Integer> lottoNum;
			for (int i = 0; i < count; i++) {
				lottoNum = new HashSet<>();
				while (lottoNum.size() < 6) {
					lottoNum.add(new Random().nextInt(45) + 1);
				}
				ArrayList<Integer> list = new ArrayList<>(lottoNum);
				Collections.sort(list);
				System.out.println("로또번호" + (i + 1) + list);
			}

			System.out.println("받은 금액은 " + money + "원이고 거스름 돈은" + (money - (1000 * count)) + "원 입니다.");

		}
	}

	public static void exit() {
		System.out.println("감사합니다.");
		System.exit(0);
	}
}
