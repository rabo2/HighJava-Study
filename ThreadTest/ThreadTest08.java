package kr.or.ddit.basic;

public class ThreadTest08 {
	public static void main(String[] args) {
		Thread th1 = new UpperThread();
		Thread th2 = new LoowerThread();

		th1.setPriority(9);
		th2.setPriority(4);
		//우선순위를 정한는 것은 cpu의 하나의 코어의 실행순서를 정한는 것인데
		//현재 컴퓨터의 코어는 최소 2개 이상이기 때문에 서로다른 코어에서 각각의
		//쓰레드가 실행되기 때문에 우선순위를 설정한 것이 효과가 없다.
		//다만, 운영체제에 따라서 다르게 실행된다.
		//unix계열에서는 코어가 여러개여도 1개로 인식하여 실행된다.
		
		System.out.println("th1의 우선순위 : "+th1.getPriority());
		System.out.println("th2의 우선순위 : "+th2.getPriority());
		
		th1.start();
		th2.start();
	}
}

// 대문자를 출력하는 쓰레드
class UpperThread extends Thread {
	@Override
	public void run() {
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.println(c);

			// 시간 지연용 반복문
			for (long i = 0; i <= 2_000_000_000L; i++) {
			}
		}
	}
}

// 소문자를 출력하는 쓰레드
class LoowerThread extends Thread {
	@Override
	public void run() {
		for (char c = 'a'; c <= 'z'; c++) {
			System.out.println(c);

			// 시간 지연용 반복문
			for (long i = 0; i <= 2_000_000_000L; i++) {
			}
		}
	}
}