package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest05 {
	public static void main(String[] args) {
		// 사용자로 부터 데이터를 입력받기

		Runnable input = new Runnable() {
			@Override
			public void run() {
				String str = JOptionPane.showInputDialog("아무거나 입력");
				// TODO Auto-generated method stub
				System.out.println("입력 값 : " + str);
			}
		};
		Thread t1 = new Thread(input);
		t1.start();
		
		
		for(int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
}
