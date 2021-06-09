package kr.or.ddit.basic;

public class ThreadTest12 {
	public static void main(String[] args) {
		StatePrintThread th = new StatePrintThread(new TargetThread());
		th.start();
	}
}

// Thread의 상태 검사 대상이 되는 Thread
class TargetThread extends Thread {

	@Override
	public void run() {
		for (long i = 1L; i <= 20_000_000_000L; i++) {
			// 시간 지연용 반복문
		}

		try {
			Thread.sleep(1500);
		} catch (Exception e) {
			// TODO: handle exception
		}

		for (long i = 1L; i <= 20_000_000_000L; i++) {
		}
	}
}

// TargetThread의 상태를 출력하는 Thread
class StatePrintThread extends Thread {
	private TargetThread target;

	public StatePrintThread(TargetThread target) {
		this.target = target;
	}

	@Override
	public void run() {
		while (true) {
			// Thread의 현재 상태 구하기
			Thread.State state = target.getState();
			System.out.println("TargetThread의 현재 상태값 : " + state);

			if (state == Thread.State.NEW) {
				// Thread의 상태가 NEW상태인지 검사
				target.start();
			} else if (state == Thread.State.TERMINATED) {
				// Thread의 상태가 종료상태인지 검사
				break;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}