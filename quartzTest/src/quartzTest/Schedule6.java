package quartzTest;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Schedule6 {
	public static void main(String[] args) {
		Timer t = new Timer();
		TimerTask task = new TimerTask() {
			int i = 1;
			@Override
			public void run() {
				if(i == 5)
					t.cancel();
				System.out.println("Timer executed at : " + new Date());
				i+=1;
			}
		};
		System.out.println("Current time : "+  new Date());
		t.schedule(task, new Date(), 2000);
	}
}
