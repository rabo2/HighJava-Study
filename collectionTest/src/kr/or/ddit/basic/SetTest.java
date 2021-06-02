package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class SetTest {
	public static void main(String[] args) {
		// HashSet<Object> set = new HashSet<>();
		//
		// set.add("DD");
		// set.add("AA");
		// set.add(2);
		// set.add(2);
		// set.add("CC");
		// set.add("BB");
		// set.add(1);
		// set.add(3);
		// //Set에 중복되는 데이터를 추가하면 false를 반환하고 데이터가 추가 되지않는다.
		//
		// System.out.println("Set 데이터 : " + set);
		// System.out.println("Set의 개수 : "+ set.size());
		//
		// boolean isAdd = set.add("FF");
		// System.out.println("중복되지 않을 때 : "+isAdd);
		//
		// isAdd = set.add("CC");
		// System.out.println("중복될 때 :"+isAdd);
		//
		//
		// // 삭제하는 메서드 remove(data) -> 반환값 : boolean
		// // clear() -> 모든 data 삭제
		// //"FF" 데이터를 "EE"로 변경하기
		// set.remove("FFF");
		// set.add("EE");
		//// set.clear();
		//// System.out.println("Set 데이터 : " + set);
		//
		//
		//// - Set형의 데이터를 Iterator형의 객체로 변환하는 메서드
		// Iterator it = set.iterator();
		//
		// //Iterator의 hasNext( )메서드
		// // -> Iterator의 포인터가 가리키는 곳의 다음번째에 데이터가 있는지 검사한다.
		// // 있으면 true, 없으면 false를 반환한다.
		// while(it.hasNext()) {
		// // Iterator의 next( )메서드
		// // -> Iterator의 포인터를 다음 번째 위치로 이동한 후 그 곳의 데이터를 반환
		// System.out.println(it.next() + " ");
		// }
		//
		// 우리반 학생들 중 번호를 이용하여 추첨하는 프로그램을 작성해 보자.
		// 번호는 1번부터 25번까지 이고, 추첨할 인원은 5명이다.
		// 당첨자를 출력해 보시오(중복당첨자는 없다.)

		// 최소값부터 최대값 사이의 정수형 난수 만들기
		// (int)(Math.random()*(최대값 - 최소값+1)+최소값)
//		HashSet<Integer> testSet = new HashSet<Integer>();
//		// while(testSet.size() < 5) {
//		// int num = (int)(Math.random()*25+1);
//		// testSet.add(num);
//		// }
//		// Iterator iterator = set.iterator();
//		// while(iterator.hasNext()) {
//		// System.out.println(iterator.next());
//		// }
//
//		while (testSet.size() < 5) {
//			testSet.add(new Random().nextInt(25) + 1);
//		}
//		for (Integer integer : testSet) {
//			System.out.println(integer);
//		}
//
//		// Set유형의 자료를 List형으로 변환하기
//		ArrayList<Integer> testList = new ArrayList<Integer>(testSet);
//
//		System.out.println("List 데이터 출력");
//		for (int i = 0; i < testList.size(); i++) {
//			System.out.println(testList.get(i));
//		}
	
		HashSet<Integer> lotto = new HashSet<Integer>();
		while(lotto.size() < 6) {
			lotto.add(new Random().nextInt(45)+1);
		}
		for (Integer num : lotto) {
			System.out.println(num);
		}
	}
}
