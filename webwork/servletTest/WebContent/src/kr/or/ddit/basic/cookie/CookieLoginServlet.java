package kr.or.ddit.basic.cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieLogin.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String check = request.getParameter("check");

		Cookie cookie = new Cookie("id", id);

		if (check != null) {
			response.addCookie(cookie);
		} else {
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}

		if (id != null && pass != null) {
			if (id.equals("admin") && pass.equals("admin")) {
				response.sendRedirect(request.getContextPath()+"/basic/03/cookieMain.jsp");
			}else {
				response.sendRedirect(request.getContextPath()+"/basic/03/cookieLogin.jsp");
			}
		}

	}
}
