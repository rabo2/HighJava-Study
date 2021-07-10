package kr.or.ddit.basic.session;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class sessionLoginServlet
 */
@WebServlet("/sessionLogin.do")
public class SessionLoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
   
   
   //로그인 처리는 POST 방식에서만 처리하고, 만약 해당 서블릿을 GET방식으로
   //요청하면 로그인 페이지로 이동하도록 한다.
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.sendRedirect(request.getContextPath() + "/basic/04/sessionLogin.jsp");
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      
      String userid = request.getParameter("userid");
      String pass = request.getParameter("pass");
      
      HttpSession session = request.getSession();
      
      if(userid.equals("admin") && pass.equals("1234")) {
         //로그인에 성공한 ID값을 세션에 저장한다.
         session.setAttribute("userId", userid);
      }
      
      RequestDispatcher rd = request.getRequestDispatcher("/basic/04/sessionLogin.jsp"); 
      // 포워드방식은 contextPath() 안쓴다..
      rd.forward(request, response);
   }

}