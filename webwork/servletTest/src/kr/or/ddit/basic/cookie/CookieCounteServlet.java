package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieCounteServlet.do")
public class CookieCounteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		/*
		Cookie[] cookies = request.getCookies();
		Cookie countCookie = null;
		int count = 0; 
		String countValue = ""; 		
		
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("count")) {
				countCookie = cookie;
				break;
			}
		}
		
		if(countCookie != null) {
			count = Integer.parseInt(countCookie.getValue())+1;
			countValue = Integer.toString(count);
			countCookie.setValue(countValue);
		}else {
			countCookie = new Cookie("count", "1");
		}
		response.addCookie(countCookie);
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Cookie 연습</title></head>");
		out.println("<body>");
		out.println("<h2>어서오세요. 당신은 "+countCookie.getValue()+"번째 방문입니다.</h2>");
	    out.println("<a href='" + request.getContextPath() 
	    + "/CookieCounteServlet.do'>카운트 증가시키기</a>");
	    out.println("<a href='" + request.getContextPath() 
	    + "/basic/03/cookieTest02.jsp'>시작문서로 가기</a>");
	    out.println("</body></html>");
	*/
	Cookie[] cookies = request.getCookies();
	int count = 0;
	if(cookies != null) {
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			if(name.equals("count")) {
				String value = cookie.getValue();
				count = Integer.parseInt(value);
			}
		}
	}
	
	count++;
	
	// 증가된 count가 저장된 쿠키 객체
	Cookie cookie = new Cookie("count", String.valueOf(count));
	response.addCookie(cookie);
	
	PrintWriter out = response.getWriter();
	
	out.println("<html><head><meta charset='utf-8'>");
	out.println("<title>Cookie 연습</title></head>");
	out.println("<body>");
	out.println("<h2>어서오세요. 당신은 "+cookie.getValue()+"번째 방문입니다.</h2>");
    out.println("<a href='" + request.getContextPath() 
    + "/CookieCounteServlet.do'>카운트 증가시키기</a>");
    out.println("<a href='" + request.getContextPath() 
    + "/basic/03/cookieTest02.jsp'>시작문서로 가기</a>");
    out.println("</body></html>");
	
	
	
	
	
	}

}
