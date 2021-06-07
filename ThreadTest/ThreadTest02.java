package kr.or.ddit.basic;

public class ThreadTest02 {
	public static void main(String[] args) {
		// 멀티 쓰레드 프로그램

		// 방법 1
		// => Thread 클래스를 상속한 class의 인스턴스를 생성한 후
		// 이 인스턴스의 start()메서드를 호출해서 사용한다.
		MyThread1 t1 = new MyThread1();
		t1.start();

		// 방법 2
		// => Runnable interface를 구현한 class의 인스턴스를 생성한 후
		// 이 인스턴스를 Thread의 인스턴스를 생성할 때 생성자의 인자값으로 넘겨준다.
		// 이 때 생성된 Thread의 인스턴스 start() 메서드를 호출해서 실행한다.
		Runnable r = new MyThread2();
		Thread t2 = new Thread(r);
		t2.start();

		for (int i = 0; i < 200; i++) {
			System.out.print("#");
		}

		// 방법 3
		// => 익명구현체(interface를 객체를 1회성으로 사용할 때) 를 이용하는 방법
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				for (int i = 1; i < 200; i++) {
					System.out.print("@");
					try {
						// Thread.sleep(시간)메서드는 주어진 시간동안 작업을 잠시 멈춘다.
						// 시간은 millisecond(1 = 1/1000초)
						Thread.sleep(100);
					} catch (InterruptedException e) {
						
					}
				}
			}
		};
		Thread t3 = new Thread(r2);
		t3.start();
		
		System.out.println("main메서드 끝...");
	}
}

// 방법 1 -> Thread 클래스를 상속받는 클래스 작성
class MyThread1 extends Thread {
	@Override
	public void run() {
		// run()메서드 안에 쓰레드에서 처리할 내용을 기술한다.
		for (int i = 1; i < 200; i++) {
			System.out.print("*");
		}
	}
}

// 방법 2 => Runnable interface를 구현한 클래스 작성
class MyThread2 implements Runnable {
	@Override
	public void run() {
		// run()메서드 안에 쓰레드에서 처리할 내용을 기술한다.
		for (int i = 1; i < 200; i++) {
			System.out.print("$");
			try {
				// Thread.sleep(시간)메서드는 주어진 시간동안 작업을 잠시 멈춘다.
				// 시간은 millisecond(1 = 1/1000초)
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
		}
	}
}