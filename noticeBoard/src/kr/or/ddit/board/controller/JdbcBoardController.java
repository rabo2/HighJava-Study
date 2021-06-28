package kr.or.ddit.board.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.board.service.JdbcBoardService;
import kr.or.ddit.board.vo.JdbcBoardVO;

public class JdbcBoardController implements JdbcBoardControllerIF {
	public static void main(String[] args) {
		new JdbcBoardController().start();
	}

	private JdbcBoardService service;
	private Scanner scan;

	private JdbcBoardController() {
		service = JdbcBoardService.getInstance();
		scan = new Scanner(System.in);
	}

	private void start() {
		displayAllBoard();
		while (true) {
			System.out.println("메뉴 : 1. 새글작성     2. 게시글보기    3. 검색    0. 작업끝");
			System.out.print("작업선택 >>");
			int num = scan.nextInt();
			switch (num) {
			case 1:
				insertNewBoard();
				break;
			case 2:
				int boardNo = showBoard();
				subPage(boardNo);
				break;
			case 3:
				searchBoard();
				break;
			case 0:
				System.out.println("게시판 프로그램 종료...");
				System.exit(0);
			default :
				System.out.println("입력 오류 입니다");
				continue;
			}
			if(num != 3)
				displayAllBoard();
		}
	}


	private void subPage(int boardNo) {
		int subNum;
		do {
			System.out.println("메뉴 : 1. 수정    2. 삭제    3. 리스트로 가기");
			System.out.print("작업선택 >>");
			subNum = scan.nextInt();
			switch (subNum) {
			case 1:
				updateBoard(boardNo);
				break;
			case 2:
				deleteBoard(boardNo);
				break;
			case 3:
				return;
			default:
				System.out.println("잘 못 입력하셨습니다.");
				break;
			}
		} while (subNum < 1 || subNum > 3);
	}

	@Override
	public void insertNewBoard() {
		scan.nextLine();
		System.out.println();
		System.out.println("새글 작성하기");
		System.out.println("-----------------------------------");
		System.out.print("-제 목 : ");
		String board_title = scan.nextLine();
		System.out.print("-작성자 : ");
		String board_writer = scan.nextLine();
		System.out.print("-내 용 : ");
		String board_content = scan.nextLine();
		JdbcBoardVO vo = new JdbcBoardVO();
		vo.setBoard_title(board_title);
		vo.setBoard_writer(board_writer);
		vo.setBoard_content(board_content);
		int check = service.insertNewBoard(vo);
		if (check > 0) {
			System.out.println("새글이 추가되었습니다.");
		} else {
			System.out.println("새글 등록에 실패하였습니다.");
		}

	}

	@Override
	public void displayAllBoard() {
		System.out.println("-------------------------------------------------------------");
		System.out.println("No\t제목\t\t작성자\t\t조회수");
		System.out.println("-------------------------------------------------------------");
		List<JdbcBoardVO> list = service.displayAllBoard();
		for (JdbcBoardVO vo : list) {
			System.out.println(vo.getBoard_no() + "\t" + vo.getBoard_title() + "\t\t" + vo.getBoard_writer() + "\t\t"
					+ vo.getBoard_cnt());
		}
		System.out.println("-------------------------------------------------------------");
	}

	@Override
	public int showBoard() {
		System.out.print("보기를 원하는 게시물 번호 입력 >>");
		int boardNo = scan.nextInt();
		System.out.println();
		System.out.println(boardNo + "번글 내용");
		System.out.println("------------------------------------------------------------");
		JdbcBoardVO vo = service.showBoard(boardNo);
		System.out.println("- 제 목 : " + vo.getBoard_title());
		System.out.println("- 작성자 : " + vo.getBoard_writer());
		System.out.println("- 내 용 : " + vo.getBoard_content());
		System.out.println("- 작성일 : " + vo.getBoard_date());
		System.out.println("- 조회수 : " + vo.getBoard_cnt());
		System.out.println("------------------------------------------------------------");
		return boardNo;
	}

	@Override
	public void updateBoard(int boardNo) {
		scan.nextLine();
		System.out.println("수정 작업하기");
		System.out.println("-----------------------------------");
		System.out.print("- 제  목 : ");
		String board_title = scan.nextLine();
		System.out.print("- 내  용 : ");
		String board_content = scan.nextLine();
		JdbcBoardVO vo = service.showBoard(boardNo);
		vo.setBoard_no(boardNo);
		vo.setBoard_title(board_title);
		vo.setBoard_content(board_content);
		int check = service.updateBoard(vo);
		if (check > 0) {
			System.out.println(boardNo + "번글이 수정되었습니다.");
		} else {
			System.out.println("수정에 실패하셨습니다.");
		}

	}

	@Override
	public void deleteBoard(int boardNo) {
		int check = service.deleteBoard(boardNo);
		if (check > 0) {
			System.out.println(boardNo + "번글이 삭제 되었습니다.");
		} else {
			System.out.println("삭제에 실패하셨습니다.");
		}

	}

	@Override
	public void searchBoard() {
		scan.nextLine();
		System.out.println("검색 작업");
		System.out.println("--------------------------------------------");
		String title = "";
		List<JdbcBoardVO> list = null;
		while (true) {
			System.out.print("- 검색할 제목 입력 : ");
			title = scan.nextLine();
			list = service.searchBoard(title);
			if (title.equals("")) {
				list = service.displayAllBoard();
			}
			if (list.size() > 0) {
				break;
			} else {
				System.out.println("존재하지 않는 게시글의 제목입니다.");
				System.out.println("다시 확인해주세요");
			}
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("No\t제목\t\t작성자\t\t조회수");
		System.out.println("-------------------------------------------------------------");
		for (JdbcBoardVO vo : list) {
			System.out.println(vo.getBoard_no() + "\t" + vo.getBoard_title() + "\t\t" + vo.getBoard_writer() + "\t\t"
					+ vo.getBoard_cnt());
		}
		System.out.println("-------------------------------------------------------------");
	}

}
