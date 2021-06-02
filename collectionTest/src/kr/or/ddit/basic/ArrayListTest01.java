package kr.or.ddit.basic;

import java.util.ArrayList;

public class ArrayListTest01 {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList();

		list1.add("aaa");
		list1.add("bbb");
		list1.add(123);
		list1.add('k');
		list1.add(true);
		list1.add(123.45);

		// contains(비교객체);
		// => 리스트에 '비교객체'가 있으면 true 없으면 false를 반환
		list1.contains("DDDD"); // true
		list1.contains("ZZZZ"); // false

		// indexOf(비교객체);
		// => 리스트에 '비교객체'가 있으면 '비교객체'가 있는 index값을 반환하고
		// '비교객체'가 하나도 없으면 -1을 반환한다.

		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("AAAA");
		list2.add("BBBB");
		list2.add("CCCC");
		list2.add("DDDD");
		list2.add("EEEE");

		list2.indexOf("AAAA"); // => 0을 반환
		list2.indexOf("ZZZZ"); // => -1을 반환

		
		// toArray() => 리스트 안의 데이터들을 배열로 변환하여 반환한다.
		// => 기본적으로 Object형 배열로 변환한다.
		Object[] array = list2.toArray();
		int length = array.length; //array의 길이는 list2의 길이와 같다.
		
		// toArray(new Generic Type[0]); => Generic Type의 배열로 변환한다.
		String[] array2 = list2.toArray(new String[0]);
		for (String str : array2) {
			System.out.println(str);
		}
		
		
		
		
	}
}
