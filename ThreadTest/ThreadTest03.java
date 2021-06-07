package kr.or.ddit.basic;

public class ThreadTest03 {
	public static void main(String[] args) {
		//쓰레드의 수행시간 체크
		Thread th = new Thread(new MyRunner());
		
		// currentTimeMillis() : 1970년 1월 1일 0시 0분 0초(표준시간)로부터 경과한
		// 시간을 밀리세컨드 단위로 반환한다.
		long startTime = System.currentTimeMillis();

		// 시간을 체크할 내용
		th.start();
		try {
			th.join(); // 현재 실행중인 쓰레드에서 대상이 되는 쓰레드(현재 th)가
					   // 종료될 때까지 기다린다. th.run()이 끝날때 까지 main Thread
					   // 를 정지 시킨다.
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("경과시간 : " + (endTime - startTime)+"/1000초");
	}
}

class MyRunner implements Runnable{
	@Override
	public void run() {
		long sum = 0L;
		for(long i = 1L; i<=1_000_000_000L; i++) {
			sum+=i;
		}
		System.out.println("합계 : "+sum);
	}
}