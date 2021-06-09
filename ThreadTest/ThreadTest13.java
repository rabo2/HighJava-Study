package kr.or.ddit.basic;

public class ThreadTest13 {
	public static void main(String[] args) {
		YieldThread th1 = new YieldThread("1번 쓰레드");
		YieldThread th2 = new YieldThread("2번 쓰레드");
		
		th1.start();
		th2.start();
		System.out.println("11111111111----------------------");
		
		th1.work =false;
		
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("22222222222----------------------");
		
		th1.work = true;

		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("33333333333----------------------");
		
		th1.stop = true;
		th2.stop = true;
		
	}
}

// yield()메서드 연습용 Thread
class YieldThread extends Thread{
	public boolean stop = false; // Thread의 종료 여부를 결정하는 변
	public boolean work = true;  // Thread가 작동 중 특정 일처리 여부를 결정하는 변수

	public YieldThread(String name) {
		super(name);	//Thread의 이름 설정
	}
	
	@Override
	public void run() {
		while(!stop) {//stop값이 true가 되면 반복문이 종료된다.
			if(work) {
				System.out.println(getName() + "- 작업중 ...");
			}else {
				System.out.println(getName() + "- 양보중...");
				Thread.yield();
				//Thread가  실행되지않고 Runnable상태일 때 반복문은 돌아가지만 아무일도 일어나지 않기
				//때문에 실행되지 않을 때느 yield()를 사용하여 실행을 양보한다.
			}
			
		}
	}
	
}