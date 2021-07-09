package kr.or.ddit.basic.reqNresp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseTest01
 */
@WebServlet("/ResponseTest01.do")
public class ResponseTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * foward
		 *  => 특정 서블릿에 대한 요청을 다른 서블릿이나 jsp문서로 넘겨준다.
		 *     (이 때 파라미터를 넘길 수 있다)
		 *  => url주소는 처음 요청할 때의 값이 바뀌지 않으며 redirect보다 성능이 좋다.
		 *     서버 내부에서만 접근이 가능하다.
		 *  
		 */
		//형식) request.getRequestDispatcher("/ResponseForward.do");
		//	   '이동할 서블릿 또는 jsp경로' => 전체 URL경로 중에서
		//								contextPath 이후의 경로를 기술한다.
		//이동할 페이지로 어떤 값을 넘기고 싶으면 request.setAttribute()메소드로
		//데이터를 셋팅하여 보내고, 받는 쪽에서 request.getAttrribute()메소드로
		//데이터를 읽어온다.
		
		//셋팅형식) request.setAttribute("key값", 보낼 데이터)
		//		=> 보낼데이터는 모든 자료형을 사용할 수 있다.
		//읽기형식) request.getAttribute("key값");
		request.setAttribute("tel", "010-123-5678");
		RequestDispatcher rd = request.getRequestDispatcher("/ResponseFowardTest.do");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
