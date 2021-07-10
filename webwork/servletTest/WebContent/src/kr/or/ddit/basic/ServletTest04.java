package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletTest04.do")
public class ServletTest04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Servlet클래스나 jsp페이지의 환경에 관려된 정보는 ServletContext인터페이스
		 * 타입객체를 이용하여 얻을 수 있다.
		 */
		ServletContext context = getServletContext();
		
		//Servlet이 속하는 웹 서버의 종류를 반환한다.
		String serverInfo = context.getServerInfo();
		
		//웹 컨테이너가 지원하는 Servlet규격의 버전 정보를 반환한다.
		//(형식 ==> 메이버 버전, 마이너버전)
		int majorVersion = context.getMajorVersion();
		int minorVersion = context.getMinorVersion();
		
		//serlvet클래스명을 반환한다
		String servletName = getServletName();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><meta charset='utf-8'>");
		out.println("<title>웹 서버 정보 보기</title></head>");
		out.println("<body>");
		out.println("<ol>");
		out.println("<li>웹서버의 종류"+serverInfo+"</li>");
		out.println("<li>Servlet Name : "+servletName+"</li>");
		out.printf("<li>Servlet Version : (%d.%d)</li>", majorVersion, minorVersion);
		out.println("</ol></body></html>");		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
