package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 서블릿의 동작 방식 및 순서
 1. 사용자(클라이언트)가 url을 클릭하면 http request를 servlet container로 전송(요청)한다.
 2. 컨테이너는 web.xml에 정의된 url패턴을 확인하여 어느 서블릿을 통해서 처리할지를 검색한다.
 	(이 때 해당 서블릿이 로딩이 안된 경우에는 로딩을 한다. 
 	그리고 처음 로딩시 init()메소드를 호출한다.
 	(Servlet버전 3.0dltkddptjsms annotation(@WebServlet)으로 url패턴을 정의할 수 있다.
 3. 서블릿 컨테이너는 요청을 처리할 개별 쓰레드 객체를 생성하여 해당 서블릿객체의
 	service()메소드를 호출한다.
 	(이 때 HttpServletRequest객체와 HttpServletResponse객체를 생성해서
 	매개변수로 넘겨 준다.)
 4. service()메소드는  Method타입을 체크하여 적절한 메소드를 호출한다.
 	(doGet(), doPost(), doPut(), doDelete() 등...)
 5. 요청 및 응답 처리가 완료되면 HttpServletRequest객체와 HttpServletResponse객체는 자동으로
 	소멸한다.
 6. 서블릿 컨테이너로부터 서블릿이 제거되는 경우에는 destroy메소드가 호출된다.
*/

//Servlet의 LifeCycle 예제
@WebServlet("/ServletTest03.do")
public class ServletTest03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("servlet : " + this.getServletName() + 
				"에서 init()메소드를 호출합니다.");
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service()메소드 시작...");
		
		//GET방식과 POST방식에 맞는 메소드 호출하기
		//방법 1 -> 현재 서블릿의 부모객체 클래스의 HttpServlet의 service()메소드로 위임하기
//		super.service(req, resp);
		
		//방법 2 -> 클라이언트의 전송방식(Get, post등)을 구분해서 직접 메소드 호출하기
		String method = ((HttpServletRequest)req).getMethod();
		System.out.println("method : " + method);
		if("GET".equals(method)) {
			doGet((HttpServletRequest)req, (HttpServletResponse)resp);
		}else {
			doPost((HttpServletRequest)req, (HttpServletResponse)resp);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()메소드 시작...");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset = 'utf-8'></head><body>"
				+ "<h1>doGet()메소드를 처리한 결과입니다.</h1></body></html>");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()메소드 시작...");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset = 'utf-8'></head><body>"
				+ "<h1>doPost()메소드를 처리한 결과입니다.</h1></body></html>");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	@Override
	public void destroy() {
		System.out.println("servlet : " + getServletName()+"에서"
				+ "destroy()메소드를 호출합니다.");
	}

}
