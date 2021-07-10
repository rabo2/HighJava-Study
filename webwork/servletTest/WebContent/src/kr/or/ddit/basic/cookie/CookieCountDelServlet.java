package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieCountDelServlet.do")
public class CookieCountDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookieArr = request.getCookies();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8"); 
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'>");
	    out.println("<title>Cookie 연습</title></head>");
	    out.println("<body>");
	    if(cookieArr == null) {
	    	out.println("<h2>count쿠키가 없습니다</h2>");
	    }else {
	    	for (Cookie cookie : cookieArr) {
				if(cookie.getName().equals("count")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					out.println("<h2>count가 초기화 되었습니다.</h2>");
				}
			}
	    }
	    out.println("<a href='" + request.getContextPath() 
	    + "/basic/03/cookieTest02.jsp'>시작문서로 가기</a>");
	    out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
