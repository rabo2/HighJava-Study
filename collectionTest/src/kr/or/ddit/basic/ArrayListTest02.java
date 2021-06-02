package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;


//이름 5개를 입력 성이 '김'씨인 사람을 출력

public class ArrayListTest02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> nameList = new ArrayList<String>();

		for (int i = 0; i < 5; i++) {
			String name = scanner.next();
			nameList.add(name);
		}

		for (String name : nameList) {
			if (name.charAt(0) == '김') {
				System.out.println(name);
			}

			if (name.startsWith("김")) {
				System.out.println(name);
			}
			if (name.indexOf("김") == 0) {
				System.out.println(name);
			}
			if (name.substring(0, 1).equals("김")) {
				System.out.println(name);
			}
		}

	}
}
