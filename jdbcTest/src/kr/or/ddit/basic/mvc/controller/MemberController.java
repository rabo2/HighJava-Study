package kr.or.ddit.mvc.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import kr.or.ddit.basic.DbUtil;
import kr.or.ddit.basic.DbUtil3;
import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImpl;
import kr.or.ddit.mvc.vo.MemberVO;

/**
 * 
 * @author PC-05
 *
 */
public class MemberController {
	private Scanner scan;
	private IMemberService service;

	public MemberController() {
		scan = new Scanner(System.in);
		service = new MemberServiceImpl();
	}

	public static void main(String[] args) {
		new MemberController().console();
	}

	private int mainPage() {
		System.out.println("---작업 선택 ---");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 전체 자료 출력");
		System.out.println("5. 자료 수정2");
		System.out.println("0. 작업 끝");
		System.out.println("------------");
		System.out.print("작업 선택 > ");
		return scan.nextInt();
	}

	private void console() {
		while (true) {
			int inputNum = mainPage();
			switch (inputNum) {
			case 1:
				insertData();
				break;
			case 2:
				deleteData();
				break;
			case 3:
				updateData();
				break;
			case 4:
				getAllMemberList();
				break;
			case 5:
				updateData2();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다");
				scan.close();
				System.exit(0);
			default:
				break;
			}
		}
	}

	private void updateData2() {
		// TODO Auto-generated method stub
		
	}

	private void insertData() {
		String memId;
		while (true) {
			System.out.print("추가할 ID 입력 : ");
			memId = scan.next();
			if (service.getMeberCount(memId) > 0) {
				System.out.println("이미 존재하는 ID입니다.");
			} else {
				break;
			}
		}
		System.out.print("PASSWORD 입력 : ");
		String memPass = scan.next();
		System.out.print("이름 입력 : ");
		String memName = scan.next();

		boolean regex;
		String memTel = "";
		while (true) {
			System.out.print("전화번호 입력 : ");
			memTel = scan.next();
			String pattern = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
			regex = Pattern.matches(pattern, memTel);
			if (regex) {
				break;
			} else {
				System.out.println("전화번호 형식이 틀렸습니다.");
			}
		}

		System.out.print("주소 입력 : ");
		String memAddr = scan.next();

		// 입력한 데이터가 저장될 VO객체 생성
		MemberVO memberVO = new MemberVO();
		memberVO.setMemId(memId);
		memberVO.setMemPass(memPass);
		memberVO.setMemName(memName);
		memberVO.setMemTel(memTel);
		memberVO.setMemAddr(memAddr);

		int cnt = service.insertMember(memberVO);
		if (cnt > 0) {
			System.out.println("회원 추가 성공");
		} else {
			System.out.println("회원 추가 실패");
		}
	}

	private void deleteData() {
		String memId = "";
		while (true) {
			System.out.print("삭제할 ID입력 : ");
			memId = scan.next();
			if (service.getMeberCount(memId) == 0) {
				System.out.println("존재하지 않는 ID입니다.");
			} else {
				break;
			}
		}
		int cnt = service.deleteMember(memId);
		if (cnt > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}

	private void updateData() {
		String memId = "";
		while (true) {
			System.out.print("수정할 ID 입력 : ");
			memId = scan.next();
			if (service.getMeberCount(memId) == 0) {
				System.out.println("존재하지 않는 ID입니다.");
			} else {
				break;
			}
		}
		System.out.print("변경할 Password 입력 : ");
		String memPass = scan.next();
		System.out.print("변경할 이름 입력 : ");
		String memName = scan.next();
		System.out.print("변경할 전화번호 입력 : ");
		String memTel = scan.next();
		System.out.print("변경할 주소 입력 : ");
		String memAddr = scan.next();
		MemberVO memberVO = new MemberVO();
		memberVO.setMemId(memId);
		memberVO.setMemPass(memPass);
		memberVO.setMemName(memName);
		memberVO.setMemTel(memTel);
		memberVO.setMemAddr(memAddr);

		int cnt = service.updateMember(memberVO);
		if (cnt > 0) {
			System.out.println("회원정보 수정완료");
		} else {
			System.out.println("회원정보 수정실패");
		}
	}

	private void getAllMemberList() {
		System.out.println("--------------------회원 목록--------------------");
		System.out.println("ID\tPASS\t이름\t전화번호\t\t주소");
		System.out.println("------------------------------------------------");
		List<MemberVO> list = service.getAllMemberList();
		for (MemberVO vo : list) {
			System.out.println(vo.getMemId()+"\t"+vo.getMemPass()+"\t"+vo.getMemName()+"\t"+vo.getMemTel()+"\t"+vo.getMemAddr());
		}
	}
}
