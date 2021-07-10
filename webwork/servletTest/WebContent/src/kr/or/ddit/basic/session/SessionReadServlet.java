package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionRead.do")
public class SessionReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Session객체 생성 또는 현재 세션 가져오기
		HttpSession session = request.getSession();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Sessio연습</title></head>");
		out.println("<body>");
		
		//저장된 세션의 key값을 정확히 알고 있을 때 사용하는 방법
		String sessionValue = (String) session.getAttribute("testSession");
		
		if(sessionValue == null) {
			out.println("<h3>testSession의 세션값은 없습니다</h3>");
		}else {
			out.println("<h3>testSession값 : "+sessionValue+"</h3>");
		}
		out.println("<hr>");
		
		//세션에 저장된 모든 key값은 getAttributeNames()메소드를 통해서 구할 수 있다.
		out.println("<h2>Session 데이터 확인하기</h2><br><br>");
		out.println("<ol>");
		Enumeration<String> sessionNames = session.getAttributeNames();
		int count = 0;
		while(sessionNames.hasMoreElements()) {
			count++;
			String sessionKey = sessionNames.nextElement();
			out.println("<li>"+sessionKey+" : "+session.getAttribute(sessionKey)+"</li>");
		}
		if(count == 0) {
			out.println("<li>세션데이터가 하나도 없습니다.</li>");
		}
		out.println("</ol>");
		out.println("<a href = '"+request.getContextPath()+"/basic/04/sessionTest.jsp'>시작문서로 가기</a>");
		out.println("</bdoy></html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
