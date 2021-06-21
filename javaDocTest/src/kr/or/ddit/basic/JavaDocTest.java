package kr.or.ddit.basic;
/*
 * Java Doc 파일 만들기 예제
 */
/**
 * 
 * @author PC-05
 * @version 1.0
 * 
 * <p>
 *  파일명 : JavaDocTest.java<br>
 *  설명 : JavaDoc문서 작성을 위한 연습용 Interface<br><br>
 *  
 *  수정 이력<br>
 *  ------------------------------<br>
 *  수정일자 : 2021-06-18<br>
 *  작성자 : 홍길동<br>
 *  수정 내용 : 최초 생성<br>
 *  ------------------------------<br>
 *  
 * </p>
 *
 */

public interface JavaDocTest {
	/**
	 * 메소드명 : methodTest<br>
	 * 기능 : 반환값이 없는 메소드<br>
	 * @param a 첫번째 매개변수(정수형)
	 * @param b 두번째 매개변수(정수형)
	 */
	public void methodTest(int a, int b);
	
	/**
	 * 메소드명 : methodAdd<br>
	 * 기능 : 정수형 데이터 2개를 인수로 받아서 합계를 반환하는 메소드
	 * @param x 합계에 사용하는 첫번째 정수형 데이터
	 * @param y 합계에 사용하는 두번째 정수형 데이터
	 * @return 매개변수 두 개의 정수형 데이터의 합
	 */
	public int methodAdd(int x, int y);

	/**
	 * 메소드명 : methodSub<br>
	 * 기능 :반환값과 매개변수가 없는 메소드
	 */
	public void methoSub();
}
