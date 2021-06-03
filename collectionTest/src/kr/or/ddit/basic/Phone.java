package kr.or.ddit.basic;

/*
	문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 만들고, 
		 Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
		 이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체출력 기능이 있다.
		 (데이터는 Map에 저장하여 관리하는데 key값으로는 '이름'을 사용하고
		 value 값으로는 'Phone클래스의 인스턴스'로 한다.)

	실행예시)
		1. 전화번호 등록
		2. 전화번호 수정
		3. 전화번호 삭제
		4. 전화번호 검색
		5. 전화번호 전체 출력
		0. 프로그램 종료
	  ==================
	   	번호 입력>>1
   
   		새롭게 등록할 전화번호정보를 입력하세요.
   
   이름>> 홍길동
	  
 */
class Phone{
	private String ph;
	private String add;
	
	public Phone() {
	}
	
	public Phone(String ph, String add) {
		this.ph = ph;
		this.add = add;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}
	
}