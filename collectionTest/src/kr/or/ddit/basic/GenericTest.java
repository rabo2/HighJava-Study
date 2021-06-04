package kr.or.ddit.basic.generic;

//Generic을 사용하지 않는 클래스
class NonGenericClass {
	private Object val;

	public Object getVal() {
		return val;
	}

	public void setVal(Object val) {
		this.val = val;
	}
}
/*
 * Generic 클래스를 만드는 방법 형식) class 클래스명<Generic type 글자>{ GenericType글자 변수명; //변수
 * 선언에 제네릭을 사용할 경우 ... GenericType글자 메서드명1(매개변수들...){// 반환값이 있는 메서드에 사용할 경우
 * 
 * ... return 값; }
 * 
 * void 메서드명2(GenericType글자 매개변수명, ...){//메스드의 매개변수에 사용할 경우
 * 
 * } }
 *
 * 
 * -- GenericType글자에 많이 사용되는 글자 -- T => TYPE K => Key V => Value E => Element
 *
 */

class MyGeneric<T> {
	private T val;

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}
}

public class GenericTest {
	public static void main(String[] args) {
		NonGenericClass ng1 = new NonGenericClass();
		ng1.setVal("안녕");

		NonGenericClass ng2 = new NonGenericClass();
		ng2.setVal(300);

		String rtn1 = (String) ng1.getVal();
		System.out.println(rtn1);

		// Integer rtn2 = (Integer) ng2.getVal();
		int rtn2 = (int) ng2.getVal();
		System.out.println(rtn2);

//		String rtn3 = (String) ng2.getVal();
//		System.out.println(rtn3);

		System.out.println("----------------------------");
		MyGeneric<String> mg = new MyGeneric<>();
		mg.setVal("대한민국");
		
		MyGeneric<Integer> mg2 = new MyGeneric<>();
		mg2.setVal(500);
		
		rtn1 = mg.getVal();
		rtn2 = mg2.getVal();
		
		System.out.println(rtn1);
		System.out.println(rtn2);
	
//		String rtn3 = mg2.getVal();
		
	
	}
	
}
