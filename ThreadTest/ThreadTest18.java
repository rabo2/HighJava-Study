package kr.or.ddit.basic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest18 {
	private int balance; // 잔액이 저장될 변수

	// Lock 객체 생성 => private final로 선언
	private final Lock lock = new ReentrantLock();

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	// 입금을 처리하는 메서드
	public void deposit(int money) {
		// Lock객체는 lock() 메소드로 락을 설정하고
		// 반드시 unLock() 메소드로 락을 해제해 주어야 한다.

		lock.lock(); // 락 설정 시작...
		balance += money;
		lock.unlock();
	}

	// 출금을 처리하는 메서드 (반환값 : 출금성공(true), 출금실패(false))
	public boolean withdraw(int money) {
		/*
		 * lock.lock();
		 * 
		 * boolean check = false; if (balance >= money) { // 잔액이 출금액 이상인지 여부 검사 for (int
		 * i = 1; i <= 1_000_000_000; i++) { } // 시간 지연용 balance -= money;
		 * System.out.println("메서드 안에서 balance = " + getBalance()); check = true; } else
		 * { check = false; } lock.unlock(); return check;
		 */

		// try~catch로 실행부를 감쌌을 떄 unlock()메소드는 finally블럭안에 존재해야한다.
		// 만약 try블럭안에 존재한다면 오류가 발생했을 때 unlock()메소드가 실행되지 않아 deadLock이 발생할 수도 있다.
		lock.lock();
		boolean check = false;
		try {
			if (balance >= money) {
				for (int i = 1; i < 1_000_000_000; i++) {
					balance -= money;
					System.out.println("Method안에서 blance = " + getBalance());
					check = true;
				}
			} else {
				check = false;
			}
		} catch (Exception e) {
		
		} finally {
			lock.unlock();
		}

		return check;
	}

	public static void main(String[] args) {
		ThreadTest18 acount = new ThreadTest18();
		acount.setBalance(10000); // 잔액을 10000원으로 설정

		// 익명 구현체로 쓰레드 구성하기
		Runnable test = new Runnable() {

			@Override
			public void run() {
				boolean result = acount.withdraw(6000); // 6000원 출금하기
				System.out.println("쓰레드에서 result = " + result + ", balance = " + acount.getBalance());

			}
		};
		// -------------------------------------------

		Thread th1 = new Thread(test);
		Thread th2 = new Thread(test);

		th1.start();
		th2.start();
	}
}