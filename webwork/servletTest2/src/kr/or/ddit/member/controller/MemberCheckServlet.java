package kr.or.ddit.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

@WebServlet("/member/memberCheck.do")
public class MemberCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String memId = request.getParameter("mem_id");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		IMemberService service = MemberServiceImpl.getInstance();
		int count = service.getMemberCount(memId);
		
		Gson gson = new Gson();
		
		String result =  null;
		
		if(count > 0) {
			result = gson.toJson("Fail");
		}else {
			result = gson.toJson("OK");
		}
		PrintWriter out = response.getWriter();
		out.println(result);
		response.flushBuffer();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
