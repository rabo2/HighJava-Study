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
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/member/memberInsert.do")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String memId = request.getParameter("mem_id");
		String memPass = request.getParameter("mem_pass");
		String memName = request.getParameter("mem_name");
		String memTel = request.getParameter("mem_tel");
		String memAddr = request.getParameter("mem_addr");
		
		MemberServiceImpl service = MemberServiceImpl.getInstance();
		
		//받은온 데이터를 vo객체에 담기
		MemberVO vo = new MemberVO();
		vo.setMem_id(memId);
		vo.setMem_pass(memPass);
		vo.setMem_name(memName);
		vo.setMem_tel(memTel);
		vo.setMem_addr(memAddr);
		
		int insert = service.insertMember(vo);
		
		//회원목록으로 이동
		response.sendRedirect(request.getContextPath()+"/member/memberList.do");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
