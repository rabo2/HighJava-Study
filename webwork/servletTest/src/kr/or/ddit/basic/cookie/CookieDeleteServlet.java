package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieDelete.do")
public class CookieDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//저장된 쿠키 삭제하기
		
		//1. 쿠키 데이터의 삭제는 쿠키의 남은 수명을 0으로 설정하는 방법을 사용한다.
		//   -쿠키의 수명은 쿠키를 저장하는 addCookie메소드를 호출하기전에
		//	    해당 쿠키의  setMaxAge()메소드를 사용한다.
		//형식) 삭제할 Cookie변수.setMaxAge(0);
		
		Cookie[] cookieArr = request.getCookies();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset = utf-8"); 
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'>");
	    out.println("<title>Cookie 연습</title></head>");
	    out.println("<body>");
	    out.println("<h2>저장된 cookie 데이터 삭제하기</h2>");
	      
	      if(cookieArr==null || cookieArr.length==0) {
	         out.println("<h3>저장된 쿠키가 하나도 없습니다.</h3>");
	      }else {
	         // 2. 쿠키 배열에서 쿠키 정보를 구해온다.
	         for(Cookie cookie : cookieArr) {
	            String name = cookie.getName(); // '쿠키변수' 가져오기
	            //쿠키변수가 'gender'인 쿠키 삭제하기
	            if("gender".equals(name)) {
	            	cookie.setMaxAge(0); //선택된 쿠키의 유지시간을  0으로 설정한다.
	            	response.addCookie(cookie);
	            	out.println("쿠키변수가 '"+name+"'인 쿠키를 삭제했습니다.");
	            }
	         }
	      }
	      out.println("<a href='" + request.getContextPath() 
	      + "/basic/03/cookieTest.jsp'>시작문서로 가기</a>");

	      out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
