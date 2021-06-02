package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest04 {
	public static void main(String[] args) {
		// 문제 1에서 별명의 길이가 같은것이 있을 경우를 처리하시오.
		// (단, 새로운 클래스에서 작업하시오.)
		Scanner scan = new Scanner(System.in);
		ArrayList<String> nameList = new ArrayList<String>();

		System.out.println("5개의 별명을 입력");
		for (int i = 0; i < 5; i++) {
			String name = scan.next();
			nameList.add(name);
		}
		int longestName = 0;
		for (int i = 0; i < nameList.size(); i++) {
			if (nameList.get(longestName).length() < nameList.get(i).length()) {
				longestName = i;
			}
		}

		for (String name : nameList) {
			if (name.length() == nameList.get(longestName).length()) {
				System.out.println("가장 길이가 긴 별명 : " + name);
			}
		}

		for (int i = 0; i < nameList.size(); i++) {
			System.out.print(nameList.get(i) + "와 길이가 같은 별명 : ");
			for (int j = 0; j < nameList.size(); j++) {
				if (nameList.get(i).length() == nameList.get(j).length()) {
					if (!nameList.get(i).equals(nameList.get(j)))
						System.out.print(nameList.get(j) + " ");
				}
			}
			System.out.println();
		}

		// 제일 긴 별명의 길이가 저장될 변수 선언 ==> list의 첫번째 데이터의 길이로 초기화 한다.
		// int maxLength = nameList.get(0).length();
		// for (int i = 0; i < nameList.size(); i++) {
		// if (maxLength < nameList.get(i).length()) {
		// maxLength = nameList.get(i).length();
		// }
		// }
		//
		// System.out.println("제일 길이가 긴 별명들...");
		// for (String name : nameList) {
		// if (maxLength == name.length()) {
		// System.out.println(name);
		// }
		// }
	}
}
