package kr.or.ddit.basic;

/*
	1~20억 까지의 합계를 구하는 프로그램을 하나의 쓰레드가 단독으로 처리할 때와
	멀티쓰레드로 처리할 때의 경과 시간을 비교
 */

public class ThreadTest04 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		SumThread sum1 = new SumThread(1L, 2_000_000_000);
		sum1.start();
		try {
			sum1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("단독 처리 경과시간 : "+(end - start));
		
		
		SumThread[] sums = new SumThread[] {
			new SumThread(1L, 500_000_000L),
			new SumThread(500_000_001L, 1_000_000_000L),
			new SumThread(1_000_000_001L, 1_500_000_000L),
			new SumThread(1_500_000_001L, 2_000_000_000L)
		};
		long startTime = System.currentTimeMillis();
		for(SumThread ss : sums) {
			ss.start();
		}
		for(int i = 0; i < sums.length; i++) {
			try {
				sums[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("멀티 쓰레드 경과 시간 : "+ (endTime - startTime));
		
	}
}

// 시작값과 종료값을 이용하여 시작값과 종료값 사이의 합계를 구하는 쓰레드 클래스 작성
class SumThread extends Thread{
	private long start;
	private long end;
	
	public SumThread() {
	}
	public SumThread(long start, long edn) {
		this.start = start;
		this.end = edn;
	}
	
	@Override
	public void run() {
		long sum = 0;
		for(long i = start; i <= end; i++) {
			sum += i;
		}
		System.out.println("합계 ("+start+"~"+end+") : " + sum);
	}
}
