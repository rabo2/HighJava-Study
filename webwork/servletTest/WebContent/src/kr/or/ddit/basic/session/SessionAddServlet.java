package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionAdd.do")
public class SessionAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Session 저장하기
		
		//1. Session객체 생성 또는 현재 세션 가져오기
		HttpSession session = request.getSession();
		
		//2. setAttribute()메소드를 사용해서 session값을 저장한다
		session.setAttribute("testSession", "연습용 세션입니다");
		session.setAttribute("userName", "홍길동");
		session.setAttribute("age", 33);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Sessio연습</title></head>");
		out.println("<body>");
		out.println("<h2>Session 데이터가 저장 되었습니다.</h2><br><br>");
		out.println("<a href = '"
				+request.getContextPath()
				+"/basic/04/sessionTest.jsp'>"
				+ "시작문서로 가기 </a>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
