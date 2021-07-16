package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/member/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_pass");
		String mem_name = request.getParameter("mem_name");
		String mem_tel = request.getParameter("mem_tel");
		String mem_addr = request.getParameter("mem_addr");
		
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(mem_id);
		memVo.setMem_pass(mem_pass);
		memVo.setMem_name(mem_name);
		memVo.setMem_tel(mem_tel);
		memVo.setMem_addr(mem_addr);
		
		int count = service.updateMember(memVo);
		response.sendRedirect(request.getContextPath()+"/member/memberList.do");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
