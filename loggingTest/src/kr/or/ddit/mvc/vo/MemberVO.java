package kr.or.ddit.mvc.vo;

//VO
public class MemberVO {
	private String memAddr;
	private String memId;
	private String memName;
	private String memPass;
	private String memTel;
	
	//VO클래스에서 별도의 생성자를 만들 때는 기본 생성자도 반드시 같이 만들어야 한다.
	//확장된 라이브러리 사용시 기본 생성자가 필수로 필요하기 때문에 기본생성자가 필요하다.
	
	public String getMemAddr() {
		return memAddr;
	}
	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemPass() {
		return memPass;
	}
	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}
	public String getMemTel() {
		return memTel;
	}
	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}
	
	
}
