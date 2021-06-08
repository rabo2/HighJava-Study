package kr.or.ddit.basic;

import java.util.Arrays;

/*
 	10마리의 말들이 경주하는 경마 프로그램을 작성하시오.
 	
 	말은 Horse라는 이름의 쓰레드 클래스로 작성하는데 
 	이 클래스는 말이름(String), 현재 위치(int), 등수(int)를 멤버변수로 갖는다.
 	
 	그리고, 이 클래스는 등수를 오름차순으로 처리할수 있는 내부 정렬 기준이 있다.(Comparable)
 	
 	경기 구간은 1 ~ 50 구간으로 되어 있다.
 	
 	 경기 중 중간에 각 말들의 위치를 아래와 같이 나타내시오.
 	Ex)
 	01번말 --->-------------------------------------------(50개)
 	02번말 ------------------->---------------------------
 	...
 	10번말 ---------------------------->------------------
 	
 	경기가 끝나면 둥수 순으로 출력한다.
 	
 */

public class ThreadTest11 {
	public static void main(String[] args) {
		Horse[] horse = new Horse[] { 
				new Horse("01번말"), 
				new Horse("02번말"), 
				new Horse("03번말"), 
				new Horse("04번말"),
				new Horse("05번말"), 
				new Horse("06번말"), 
				new Horse("07번말"), 
				new Horse("08번말"), 
				new Horse("09번말"),
				new Horse("10번말") 
		};

		GamePrint gamePrint = new GamePrint(horse);
		for (Horse h : horse) {
			h.start();
		}
		gamePrint.start();

		for (Horse h : horse) {
			try {
				h.join();
			} catch (InterruptedException e) {

			}
		}
		try {
			gamePrint.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n경기 종료\n");
		Arrays.sort(horse);
		for (int i = 0; i < horse.length; i++) {
			System.out.println((i + 1) + "등  " + horse[i].getHoreseName());
		}
	}
}

class Horse extends Thread implements Comparable<Horse> {
	private String horseName;
	private int location;
	private int rank;
	public static int saveRank;
	
	public Horse(String name) {
		this.horseName = name;
	}

	public Horse() {
	}

	public String getHoreseName() {
		return horseName;
	}

	public void setHorseName(String name) {
		this.horseName = name;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			location = i;
			try {
				Thread.sleep((int) (Math.random() * (501) + 500));
			} catch (InterruptedException e) {

			}
		}
		System.out.println(getHoreseName() + "도착...");
		rank = ++saveRank;
	}

	@Override
	public int compareTo(Horse horse) {
		return Integer.compare(this.rank, horse.rank);
	}
}

class GamePrint extends Thread {
	private Horse[] horse;

	public GamePrint(Horse[] horse) {
		this.horse = horse;
	}

	@Override
	public void run() {
		while (true) {
			if(Horse.saveRank == horse.length) {
				break;
			}
			System.out.println("\n\n");
			for (int i = 0; i < horse.length; i++) {
				System.out.print(horse[i].getHoreseName() + " : ");
				for (int j = 0; j < 50; j++) {
					if (horse[i].getLocation() == j) {
						System.out.print(">");
					} else {
						System.out.print("-");
					}
				}
				System.out.println();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
		}
	}
}
