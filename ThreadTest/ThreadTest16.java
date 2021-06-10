package kr.or.ddit.basic;

public class ThreadTest16 {
	public static void main(String[] args) {
		ShareObject obj = new ShareObject();
		
		TestThread th1 = new TestThread("1번 Thread", new ShareObject());
		TestThread th2 = new TestThread("2번 Thread", new ShareObject());
		
		th1.start();
		th2.start();
	}
}

// 연습용 Thread
class TestThread extends Thread {
	private ShareObject sObj;

	public TestThread(String name, ShareObject sObj) {
		super(name); 		//Thread 이름 설정
		this.sObj = sObj;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			sObj.add();
		}
	}

}

// 공통으로 사용할 클래스
class ShareObject {
	private int sum = 0;
	
	//동기화 처리 하기
	public synchronized void add() {
		synchronized (this) {// 방법 2 :동기화 블럭으로 설정한다.
			
		}
		int n = sum;
		n += 10;
		sum = n;
		System.out.println(Thread.currentThread().getName() + "합계 : " + sum);

	}
}
