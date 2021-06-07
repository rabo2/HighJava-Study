package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest06 {
	public static void main(String[] args) {
		DataInput th1 = new DataInput();
		CountDown th2 = new CountDown();
		
		th1.start();
		th2.start();
		
	}
}

// 데이터를 입력받는 쓰레드
class DataInput extends Thread {
	// 입력 여부를 확인하기 위해 변수선언(Thread에서 공통으로 사용할 변수)
	public static boolean check = false;
	
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("아무거나 입력");
		check = true; // 입력이 완료되면 check값을 true로 변경
		System.out.println("입력 값 : " + str);
	}
}

// 카운트 다운을 처리하는 쓰레드
class CountDown extends Thread {
	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {//check의 값 확인하여 입력완료 여부를 확인,
									  // 입력완료시 쓰레드 종료
			if(DataInput.check == true) {
				return; //run() 메서드 종료시 쓰레드도 종료
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("입력시간 초과 프로그램 종료");
		System.exit(0);
	}
}
