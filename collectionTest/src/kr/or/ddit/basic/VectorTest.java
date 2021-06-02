package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest {
	public static void main(String[] args) {
		
		Vector v1 = new Vector();
		
		//데이터 추가 : add(추가 데이터)
		System.out.println("처음크기 : "+ v1.size());
		v1.add("aaa");
		v1.add(new Integer(111)); //Wrapper class
		v1.add(123); // Auto Boxing 으로 Wrapper class로 치환해준다.
		v1.add('a');
		v1.add(true); 
		boolean r = v1.add(3.14); //add의 리턴타입은 boolean이다.
		
		System.out.println("현재 크기 : "+ v1.size());
		System.out.println("반환값 : "+ r);
		
		System.out.println("v1 =>" + v1);
		
		
		// 데이터 추가하기 : addElement(추가할 데이터);
		//   => 이전 버전의 프로그램도 사용할 수 있도록하기 위해 남아있는 메서드
		v1.addElement("CCC");
		System.out.println("v1 =>" + v1);
		
		// 데이터 추가하기 : add(index, 데이터)
		//   => 'index'번째에 '데이터'를 끼워 넣는다.
		//	 => 'index'는 0부터 시작, 반환값은 없다.
		//   => 기존에 존재하던 데이틑 순서가 밀려서 저장된다.
		v1.add(1, "kkk");
		System.out.println("v1 =>" + v1);
		
		
		// 데이터 수정 : set(index, new data);
		//	=> 'index'번째의 데이터를 'new data'로 덮어쓴다.
		//	=> 반환값 : 기존의 data
		String temp = (String) v1.set(0, "zz");
		System.out.println(temp);
		System.out.println("v1 =>" + v1);
		
		// 데이터 삭제 : remove(index);
		//	=> 'index'번째의 데이터를 삭제한다.
		//	=> 반환값 : 삭제된 데이터
		
		temp = (String) v1.remove(0);
		System.out.println("삭제 된 data : "+temp);
		System.out.println("v1 =>" + v1);
		
		
		// 데이터 삭제 : remove(data);
		//	=> '삭제할 데이터'를 찾아 삭제한다.
		//	=> 중복값이 존재하면 가장 앞에 있는 1개의 data만 삭제한다.
		//	=> 반환값은 boolean
		//	=> '삭제할데이터'가  '정수형'이거나 'char형'일 경우에는 반드시
		//		Wrapper클래스로 객체로 변환해서 사용해야 한다.
		boolean remove = v1.remove("CCC");
		v1.remove(new Integer(123)); 
		v1.remove(new Character('a'));
		System.out.println("v1 =>" + v1);

		//데이터 꺼내오기 : get(index)
		//	=> 'index'번재의 데이터를 반환한다.
		int data = (int) v1.get(1);


		
		Vector<String> v2 = new Vector<String>();
		Vector<Integer> v3 = new Vector<>();
		Vector<Vector> v4 = new Vector<>();
		
		//전부 삭제
		v1.clear();
		

		// 데이터 삭제 : removeAll(Collection 객체)
		//	=> 'Collection객체'가 가지고 있는 데이터를 모두 삭제한다.
		//	=>	반환값 : boolean
		//v2에도 존재하고 v4에도 존재하는 v2의  data삭제
		
		v2.add("AAAA");
		v2.add("BBBB");
		v2.add("CCCC");
		v2.add("EEEE");
		
		
		
		for (String s : v2) {
			System.out.println(s);
		}
		
		
	}
}

