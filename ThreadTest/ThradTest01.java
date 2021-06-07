package kr.or.ddit.basic;

public class ThradTest01 {
	public static void main(String[] args) {
		//싱글 쓰레드 프로그램
		//순서대로 코드가 실행된다.
		for (int i = 1; i < 200; i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println();

		for(int i = 1; i<200; i++) {
			System.out.print("$");
		}
	}
}
