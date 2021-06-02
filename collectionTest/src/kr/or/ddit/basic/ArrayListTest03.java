package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest03 {
	public static void main(String[] args) {
		// 5명의 별명을 입력 받아 ArrayList를 저장
		// 별명의 길이가 제일 긴 별명을 출력하시오.
		// 단, 각 별명의 길이는 모두 다르게 입력한다.

		Scanner scan = new Scanner(System.in);
		ArrayList<String> nameList = new ArrayList<String>();

		for (int i = 0; i < 5; i++) {
			System.out.print(i + "번째 별명 : ");
			String name = scan.next();
			nameList.add(name);
		}
		int longestName = 0;
		for (int i = 0; i < nameList.size(); i++) {
			if (nameList.get(longestName).length() < nameList.get(i).length()) {
				longestName = i;
			}
		}
		System.out.println(nameList.get(longestName));

		// 문제 1에서 별명의 길이가 같은것이 있을 경우를 처리하시오.
		// (단, 새로운 클래스에서 작업하시오.)

//		String maxAlias = nameList.get(0);
//		for (int i = 1; i < nameList.size(); i++) {
//			if (maxAlias.length() < nameList.get(i).length()) {
//				maxAlias = nameList.get(i);
//			}
//		}
//		System.out.println("제일 긴 별명 : "+maxAlias);
	}
}
