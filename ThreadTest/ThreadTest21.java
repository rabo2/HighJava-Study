package kr.or.ddit.basic;

public class ThreadTest21 {
	public static void main(String[] args) {
		
		DataBox box = new DataBox();
		ProducerThread th1 = new ProducerThread(box);
		ComsumerThread th2 = new ComsumerThread(box);
		
		th1.start();
		th2.start();
		
		
	}
}


// 데이터를 공토으로 사용하는 class
class DataBox{
	private String data;

	// 데이터를 공급하는 메소드
	// => data 필드에 값이 있으면 data가 null이 될 때까지 대기
	// => data 필드가 null이 되면 새로운 data를 변수에 저장
	public synchronized void setData(String data) {
		if(this.data != null) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.data = data; // 새로운 data 저장
		System.out.println("Thread에서 새로 저장한 데이터 : " + data);
		notify();
	}
	//데이터를 사용하는 메소드
	// => data변수의 값이 null이면 data변수에 새로운 데이터가 저장될 때까지 대기
	// => data의 값이 존재하면 해당 data를 반환
	// => 반환 후에는 data변수값을 null로 초기화
	public synchronized String getData() {
		if(data == null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String returnData = this.data;
		System.out.println("Thread가 읽은 데이터 : " + returnData);
		this.data = null;
		notify();
		return returnData;
	}
}

//데이터를 넣어주는 Thread
class ProducerThread extends Thread	{
	private DataBox box;

	public ProducerThread(DataBox box) {
		this.box = box;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 3; i++) {
			box.setData("공급데이터 - " + i);
		}
	}
	
}

//데이터를 꺼내서 사용하는 Thread
class ComsumerThread extends Thread {
	private DataBox box;

	public ComsumerThread(DataBox box) {
		this.box = box;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 3; i++) {
			String data = box.getData();
			
		}
	}
}


