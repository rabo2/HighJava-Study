package kr.or.ddit.basic;

/*
 * wait(), notify() 메소드를 이용한 두  Thread에서
 * 번갈아 한번씩 실행하는 예쩨
 * wait(), notify(), notifyAll()은 동기화 영역에서만 사용 가능한다.
 */

public class ThreadTest20 {
	public static void main(String[] args) {
		WorkObject work = new WorkObject();

		ThreadA th1 = new ThreadA(work);
		ThreadB th2 = new ThreadB(work);

		th1.start();
		th2.start();

	}
}

// 공통으로 사용할 객체
class WorkObject {
	public synchronized void methodA() {
		System.out.println("methodA() method 실행 중");

		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void methodB() {
		System.out.println("methodB() method 실행 중");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

// WorkObject의 methodA() 메서드만 호출하는 Thread
class ThreadA extends Thread {
	private WorkObject work;

	public ThreadA(WorkObject work) {
		this.work = work;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			work.methodA();
		}
		// 마지막에 waiting pool에 있는 Thread를 깨워주는 역활.
		synchronized (work) {
			work.notify();
		}
	}
}

class ThreadB extends Thread {
	private WorkObject work;

	public ThreadB(WorkObject work) {
		this.work = work;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			work.methodB();
		}
		synchronized (work) {
			work.notify();
		}
	}

}
