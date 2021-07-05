package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 이 예제는 annotation을 이용하여  Servlet을 설정해 처리하는 예제이다.
 * (annotation name : @WeebServlet)
 * annotation은 servlet버전 3.0이상부터 사용 가능
 */

/*
 * @WebServlet annotation의 속성들
 * 1. name : 서블릿 이름을 서블릿 이름을 설정한다.(기본값 : 빈문자열(""))
 * 2. urlPatterns : 서블릿의 URL패턴의 목록을 설정한다.(기본값 : 빈배열({}))
 * 		ex) 패턴이 1개일 경우 -> urlPatterns = "/url" 또는 urlPatterns = {"/url"}
 * 		ex) 패틴이 2개 이상일 경우 -> urlPatterns = {"/url1", "/url2",...}
 * 3. value : urlPatterns와 동일한 긴으을 한다.
 * 4. description : 주석(설명글)을 설정한다.
 */

@WebServlet(urlPatterns = {"/servletTest02.do"},
description = "annotation을 이용한 서블릿 설정 예제")

public class ServletTest02 extends HttpServlet {
	 private static final long serialVersionUID = 1L; 
	   //serialVersionUID> 직렬화해서 보내는데이터 역직렬화해서 보낼때 그 데이터가 같은지..? 그거확인하는것
	   
	   // 이 부분에는 대부분 service()메서드 또는 doGet()메서드나 doPost()메서드를
	   // 재정의해서 작성한다.
	   
	   // doGet()메서드나 doPost()메서드는 service()메서드를 통해 호출된다.
	   // 위 메서드들은 다음과 같은 객체를 매개변수(파라미터)로 받는다. 2개를 받음
	   // - HttpServletRequest객체 : 서비스 요청에 관련된 정보 및 메서드를 제공하는 객체
	   // - HttpServletResponse객체 : 서비스 응답에 관련된 정보 및 메서드를 제공하는 객체
	   
	   // doGet()메서드 ==> GET방식의 요청을 처리하는 메서드
	   
	   @Override
	   protected void doGet(HttpServletRequest request
	         , HttpServletResponse response) throws ServletException, IOException {
	      
	      response.setCharacterEncoding("utf-8"); // 응답문서의 인코딩 방식 지정 //pageEncoding이랑 비슷하다가 생각하면됨
	      response.setContentType("text/html; charset=utf-8"); //응답 문서의 ContentType 지정 jsp써있는 것을 써준거라생각하면됨
	      
	      // 처리한 내용을 응답으로 보내기 위한 PrintWriter객체 생성하기
	      PrintWriter out = response.getWriter();  
	      
	      // 처리한 내용을 출력한다.
	      // 방법 2 : print(), println()메서드 이용하기
	      out.print("<html>");
	      out.println("<head>");
	      out.println("<meta charset = 'utf-8'");
	      out.println("<title>두번째 Servlet연습</title>");
	      out.println("</head>");
	      out.println("<body>");
	      out.println("<h1 style = 'text-align:center; color:red;'");
	      out.println("두번째 Servlet예제 입니다. <br>");
	      out.println("이것은 annotation으로 설정한 Servlet입니다.");
	      out.println("</h1>");
	      out.println("</body>");
	      out.print("</html>");
	   }
	   
	   // doPost()메서드 ==> POST방식의 요청을 처리하는 메서드   
	   @Override
	   protected void doPost(HttpServletRequest request, 
	         HttpServletResponse response) throws ServletException, IOException {
	      // TODO Auto-generated method stub
	      super.doPost(request, response);
	   }
}
