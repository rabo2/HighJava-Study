package kr.or.ddit.basic;

import java.util.Random;

import javax.swing.JOptionPane;

public class ThreadTest07 {
	public static void main(String[] args) {
		Thread th1 = new Thread(new RckGame());
		Thread th2 = new GameCountDown();

		th1.start();
		th2.start();
	}
}

class RckGame implements Runnable {
	public static boolean timeCheck = false;

	@Override
	public void run() {
		String user = JOptionPane.showInputDialog("셋(가위, 바위, 보) 중 하나를 입력하세요");
		timeCheck = true;
		String[] computerArray = { "가위", "바위", "보" };
		String computer = computerArray[new Random().nextInt(3)];
		System.out.println("---결과----");
		System.out.println("컴퓨터 : " + computer);
		System.out.println("사용자 : " + user);
		playGame(user, computer);
	}

	private void playGame(String user, String computer) {
		if (user.equals(computer)) {
			System.out.println("무승부");
		} else if ((user.equals("가위") && computer.equals("보")) 
				|| (user.equals("보") && computer.equals("바위"))
				|| (user.equals("바위") && computer.equals("가위"))) {
			System.out.println("유저 승리");
		} else {
			System.out.println("컴퓨터 승리");
		}
	}
}

class GameCountDown extends Thread {
	@Override
	public void run() {
		for (int i = 5; i > 0; i--) {
			if (RckGame.timeCheck == true) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("시간초과하여 당신의 패배입니다.");
		System.exit(0);
	}
}
