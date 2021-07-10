package kr.or.ddit.basic.json;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/LprodServlet.do")
public class LprodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LprodDao dao = LprodDao.getInstance();
		List<LprodVO> list = dao.getLprodList();
		System.out.println(list.size());
		Gson gson = new Gson();
		
		String json = gson.toJson(list);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json charset=utf-8"); 
		
		PrintWriter out = response.getWriter();
		out.write(json);
		response.flushBuffer();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
