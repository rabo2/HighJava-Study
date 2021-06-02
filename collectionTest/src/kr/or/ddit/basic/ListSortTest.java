package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/*
 * 정렬과 관련된 interface는 Comparable, Comparator 이렇게 두 가지가 있다.
 * Comparable은 Collection에 추가되는 데이터 자체에 정렬 기준을 넣고 싶을 때(내부 정렬 기준)
 * 구현하는 interface이다.
 *  Comparator는 외부에 별도로 정렬 기준을 구현하고 싶을 때 (외부 정렬 기준) 구현하는 interface이다.
 *  Comparable에서는 compareTo()메서드를 재정의하고, Comparator에서는 compare()메서드를
 *  재정의 해야 한다.
 *  
 *  
 *  
 */



public class ListSortTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();

		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");

		System.out.println("정렬전 :" + list);

		Collections.sort(list);
		System.out.println("정렬후 :" + list);
		
		Collections.shuffle(list);//자료 섞기
		
		System.out.println("자료 섞기 후 : "+list);
		
		//외부 정렬 기준 클래스를 지정해서 정렬하기
		Collections.sort(list, new Desc());
		System.out.println("내림차순 정렬 후 : "+ list);
	}
}

// 정렬방식을 정해주는 class만들기 (외부 정렬 기준 클래스라고 한다)
// -> Comparator 인터페이스를 구현해 작성한다.
class Desc implements Comparator<String> {
	// compare() 메서드를 이용해서 정렬하고자 하는 기준을 정해준다.
	// 두 값이 같으면 0을 반환한다.
	// 양수를 반환하면 앞, 뒤의 순서를 바꾼다.
	// 음수를 반환하면 순서를 바꾸지 않는다.

	@Override
	public int compare(String str1, String str2) {
		// 내림차순으로 구현하려고 한다.
		if (str1.compareTo(str2) > 0) {
			return -1;
		} else if (str1.compareTo(str2) < 0) {
			return 1;
		} else {
			return 0;
		}
	}
}

