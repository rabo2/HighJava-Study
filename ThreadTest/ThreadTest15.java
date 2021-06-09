package kr.or.ddit.basic;

//Thread에서 객체를 공통으로 사용하는 프로그램

/*
 * 원주율을 계산하는 Thread와
 * 계산된 원주율을 출력하는 Thread가 있다.
 * 
 * 원주율을 저장하는 객체가 필요하다.
 * 이 객체를 두 Thread가 공통으로 사용해서 처리한다.
 */

public class ThreadTest15 {
	public static void main(String[] args) {
		System.out.println("작업 시작...");
		
		// 공통으로 사용할 객체 생성
		ShareData sd = new ShareData();

		// Thread 객체
		Thread cal = new CalcPIThread(sd);
		Thread print = new PrintPIThread(sd);

		cal.start();
		print.start();
		
	}

}

// 원주율을 관리하는 클래스(공통으로 사용할 클래스)
class ShareData {
	public double result; // 계산된 원주율이 저장될 변수
	public volatile boolean isOk = false; // 계산이 완료되었는지 여부를 나타내는 변수
	
	
	//volatile => cpu의 각 코어에는 캐쉬가 존자하는데 이 캐쉬를 사용하지 않고 직접 메모리에서 데이터값을 입출력한다.
	
	//cpu는 코어의 cache에 데이터를 저장하여 사용한다. Multi Thread를 사용할 경우 현대 컴퓨터의 성능에서는 
	//여러 개의 코어를 사용하게 되는데
	//처리속도는 매우 빠르지만 공통된 데이터를 사용할 경우 변수가 초기화 된 것을 각자의 cache에만 저장하고 서로가 접근을 하지 못한다.
	//그래서 여러 Thread가 공통으로 사용하는 변수가 존재하는 경우 volatile을 사용하여 변수를 메모리 영역에 저장하여 모든 Thread가
	//공유를 할 수 있게 한다.
}

// 원주율을 계산하는 Thread
class CalcPIThread extends Thread {
	private ShareData data;

	public CalcPIThread(ShareData data) {
		this.data = data;
	}

	@Override
	public void run() {
		/*
		 * 원주율 = (1/1 - 1/3 + 1/5 - 1/7 + ...)*4
		 */
		double sum = 0.0;
		for (int i = 1; i <= 2_000_000_000; i += 2) {
			if ((i / 2) % 2 == 0) {
				sum += 1.0 / i;
			} else {
				sum -= 1.0 / i;
			}
		}
		data.result = sum * 4;
		data.isOk = true;
	}

}

// 계산된 원주율을 출력하는 Thread
class PrintPIThread extends Thread {
	private ShareData data;

	public PrintPIThread(ShareData data) {
		this.data = data;
	}

	@Override
	public void run() {
		while (true) {
			if (data.isOk) {// 계산이 완료되었는지 검사
				break;
			}
		}
		System.out.println("\n결과 : " + data.result);
		System.out.println("PI : " + Math.PI);
	}

}