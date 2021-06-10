package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class ThreadTest19 {
	/*
	 * Vector, HashTable 등 예전부터 존재하던 Collection객체들은 내부에
	 * 동기화 처리가 되어있다. 
	 * 
	 * 하지만, 새로 구성된 Collection객체들은 동기화 처리가 되어있지 않다.
	 * 그래서 동기화 처리가 필요한 프로그램에서 이런 Collection들을 사용하려면
	 * 동기화 처리를 한 후에 사용해야 한다.
	 */
	
	// Vector는 내부적으로 동기화 존재한다.
	private static Vector<Integer> vec = new Vector<>();

	// 비슷한 List는 add() 기본으로 정해진 배열의 크기를 벗어날 때 더큰 크기의 배열을 생성하고
	// 원래 있던 데이터를 더 큰 배열로 복사한다. 이 때 add() 메소드에 동기화 처리가 되어있지 않기 때문에
	// 동기화를 하지 않으면 데이터가 제대로 복사되지 않고 오류를 발생시킨다.
	private static List<Integer> list1 = new ArrayList<>();

	// 동기화 처리를 한 List객체 생성
	private static List<Integer> list2 = Collections.synchronizedList(new ArrayList<>());
	
	public static void main(String[] args) {
		// 익명 구현체로 Thread 구현
		Runnable r = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					list1.add(i);
				}
			}
		};
		//---------------------------------------
		Thread[] ths = new Thread[] {
				new Thread(r),
				new Thread(r),
				new Thread(r),
				new Thread(r),
				new Thread(r)
		};
		
		for (Thread th : ths) {
			th.start();
		}
		for (Thread th : ths) {
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		System.out.println("vec의 개수 :" + vec.size());
		System.out.println("list1의 개수 : " + list1.size());
		
	}
}
