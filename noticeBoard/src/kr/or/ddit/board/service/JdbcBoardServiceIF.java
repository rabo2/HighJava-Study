package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.JdbcBoardVO;

public interface JdbcBoardServiceIF  {
	/**
	 * 새 게시글을 작성하여 입력하는 메소드
	 * @param jdbcBoardVO 새로운 게시글의 데이터를 받아서 vo객체에 저장하여 매개변수로 받는다.
	 * @return 저장 성공 여부 성공 : 1, 실패 : 0
	 */
	public int insertNewBoard(JdbcBoardVO jdbcBoardVO);
	
	/**
	 * 전체 게시글을 출력하는 메소드
	 * @return DB의 데이터를 순서대로 List에 담아서 반환
	 */
	public List<JdbcBoardVO> displayAllBoard();
	
	/**
	 * 특정 게시글을 보는 메소드
	 * @param boardNo 보려하는 게시글의 번호를 매개변수로 받는다.
	 * @return 검색한 게시글의 데이터를 vo에 담아서 반환
	 */
	public JdbcBoardVO showBoard(int boardNo);

	/**
	 * 게시글 제목 , 내용을 수정하는 메소드
	 * @param jdbcBoardVO 수정하려는 제목, 내용을 담고있는 vo객체
	 * @return
	 */
	public int updateBoard(JdbcBoardVO jdbcBoardVO);
	
	/**
	 * 게시글을 삭제하는 메소드
	 * @param boardNo 삭제하려는 게시글의 번호를 매개변수로 받는다.
	 * @return 삭제 성공 여부를 반환 성공 : 1, 실패 : 0 
	 */
	public int deleteBoard(int boardNo);
	
	/**
	 * 제목을 통해 게시글을 검색하는 메소드
	 * @param title 검색하려는 게시글의 제목을 매개변수로 받는다.
	 * @return 게시글의 내용을 vo객체로 저장하여 반환
	 */
	public List<JdbcBoardVO> searchBoard(String title);
	
	/**
	 * 조회수를 증가시키는 메소드
	 * @param boardNo 조회수가 증가되는 게시글의 번호
	 */
	public void increaseCount(int boardNo);
	
	/**
	 * 검색한 제목이 존재하는지 확인하는 메소드
	 * @param boardNo 제목을 조회하기위한 입력 매개변수
	 * @return 존재한다면 0이상 존재하지 않으면 0
	 */
	public int checkTitle(String title);
}
