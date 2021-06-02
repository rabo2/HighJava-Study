package kr.or.ddit.basic;

import java.util.LinkedList;

public class StackTest {
	public static void main(String[] args) {
		Browser b = new Browser();
		
		b.goURL("1.네이버");
		b.hidtory();
		
		
		b.goURL("2.야후");
		b.goURL("3.구글");
		b.goURL("4.다음");
		b.hidtory();
		
		System.out.println("뒤로가기 후 ...");
		b.goBack();
		b.hidtory();

		System.out.println("뒤로가기 후 ...");
		b.goBack();
		b.hidtory();
	
		System.out.println("앞으로가기 후 ...");
		b.goForward();
		b.hidtory();
		
		System.out.println("새로운 사이트 접속하기");
		b.goURL("5.네이트");
		b.hidtory();
	}
}

// 웹 브라우자의 앞으로 가기, 뒤로가기 기능 구현(스택 이용)

class Browser{
	private LinkedList<String> back; //이전 방문 내역이 저장될 스택
	private LinkedList<String> forward; // 다음 방문 내역이 저장될 스택
	private String currentUrl;
	
	public Browser() {
		this.back = new LinkedList<>();
		this.forward = new LinkedList<>();
		this.currentUrl = "";
	}
	
	//사이트를 방문하는 메서드 => 매개변수에는 방문할 싸이트가 저장된다.
	public void goURL(String url) {
		if(back.size()>=10) {
			System.out.println("back에 더 이상 추가할 수 없습니다.");
			return;
		}
		System.out.println(url + "싸이트에 접속합니다...");
		
		if(currentUrl!=null && !"".equals(currentUrl)) {
			//현재페이지가 있으면
			back.push(currentUrl); // 현재 페이지를 back스택에 저장한다.
		}
		currentUrl = url;
	}
	
	//뒤로가기
	public void goBack() {
		// back스택에 데이터가 있는지 검사
		// isEmpty()메서도 이용 => List에 자료가 하나도 없으면 true
		if(!back.isEmpty()) {
			forward.push(currentUrl);//현재 페이지를 forward에 추가
			currentUrl = back.pop(); //back에서 1개의 요소를 꺼내와 현재 페이지로 한다.
		}
	}
	
	//앞으로 가기
	public void goForward() {
		if(!forward.isEmpty()) {
			back.push(currentUrl); //현재 페이지를 back에 추가
			currentUrl = forward.pop(); //forward에서 1개의 요소를 꺼내와 현재 페이지로 저장
		}
	}
	
	public void hidtory() {
		System.out.println("---------------");
		System.out.println("   방   문   기   록");
		System.out.println("---------------");
		System.out.println("back : "+back);
		System.out.println("현재페이지 : "+currentUrl);
		System.out.println("forward : "+ forward);
		System.out.println("---------------");
	}
}