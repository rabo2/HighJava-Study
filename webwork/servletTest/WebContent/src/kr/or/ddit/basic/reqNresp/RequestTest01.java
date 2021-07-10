package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestTest01.do")
public class RequestTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post방식으로 전송된 데이터의 인코딩 방식 설정
		request.setCharacterEncoding("utf-8");

		// getParameter("파라미터명") ==> 해당 파라미터에 설정된 '값'을 가져온다.
		// ==> 가져온 '값'의 자료형은 'String'이다.
		String userName = request.getParameter("username"); // 파라미터가 username인걸 가져와라!!!!!!
		String job = request.getParameter("job");

		// getParameterValues("파라미터명")
		// ==> 파라미터명이 같은 것이 여러개 일 경우에 사용한다.
		// ==> 가져오는 '값'의 자료형은 'String[]'이다.

		String[] hobbies = request.getParameterValues("hobby"); // form에 있는 name이름

		// 출력하기
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<html><head><meta charset='utf-8'>");
		out.println("<title>Request객체 연습</title></head>");
		out.println("<body>");
		out.println("<h2>Request 테스트 결과-1</h2>");
		out.println("<hr>");
		out.println("<table border='1'?");
		out.println("<tr><td>이름</td>");
		out.println("<td>" + userName + "</td></tr>");
		out.println("<tr><td>직업</td>");
		out.println("<td>" + job + "</td></tr>");
		out.println("<tr><td>취미</td>");
		out.println("<td>");
		// 배열 크기만큼 반복문을 처리한다.
		// for(int i=0; i<hobbies.length; i++) {
		// out.println(hobbies[i] + "<br>");
		// }
		if (hobbies != null) {
			for (String hobby : hobbies) {
				out.println(hobby + "<br>");
			}
		}
		out.println("</td></tr>");
		out.println("</table>");
		out.println("<h2>Request 테스트 결과-2</h2>");
		out.println("<table border = '1'><tr><td>");
		out.println("1. 클라이언트 주소 : " + request.getRemoteAddr() + "<br>");
		out.println("2. 요청 메소드 : " + request.getMethod() + "<br>");
		out.println("3. Context Path : " + request.getContextPath() + "<br>");
		out.println("4. 프로토콜 : " + request.getProtocol() + "<br>");
		out.println("5. URL정보 : " + request.getRequestURL() + "<br>");
		out.println("6. URI정보 : " + request.getRequestURI() + "<br>");
		out.println("</td></tr></table>");
		out.println("<hr>");
		// getParameterNames() => 전송된 모든 파라미터명을
		// Enumeration<String>객체에 담아서 반환한다.
		out.println("<h2>Request 테스트 결과 - getParameterNames()메소드</h2>");
		out.println("<ol>");
		Enumeration<String> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String name = params.nextElement();
			out.println("<li>" + name + "</li>");
		}
		out.println("</ol>");
		out.println("<hr>");

		// getParamenterMap()
		// => 전송된 모든 파라미터 정보를 Map객체에 담아서 반환한다.
		// => 이 Map의 key값은 '파라미터명'이 되고
		// => value값은 해당 파라미터의 '값'(String[])이 된다.
		Map<String, String[]> paraMap = request.getParameterMap();
		out.println("<h2>Request 테스트 결과 - getParameterMap()메소드</h2>");
		out.println("<table border = '1'>");
		out.println("<tr><td>파라미터Name</td><td>파라미터Value</td></tr>");
		for (String paramName : paraMap.keySet()) {
			out.println("<tr><td>" + paramName + "</td><td>");
			
			//key값을 이용해서 파라미터 값 구하기
			String[] paramValue = paraMap.get(paramName);
			if (paramValue == null || paramValue.length == 0) {// 파라미터 값이 없는경우
				continue;
			} else if (paramValue.length == 1) {// 파라미터가 배열이 아닌경우
				out.println(paramValue[0]);
			} else {
				for (int i = 0; i < paramValue.length; i++) {
					out.println(paramValue[i] + "<br>");
				}
			}
			out.println("</td></tr>");
		}
		out.println("</table>");
		
		out.println("</body></html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}