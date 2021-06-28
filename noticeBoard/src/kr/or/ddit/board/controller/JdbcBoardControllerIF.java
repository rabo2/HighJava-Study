package kr.or.ddit.board.controller;

public interface JdbcBoardControllerIF {
	public void insertNewBoard();

	public void displayAllBoard();
	
	public int showBoard();

	public void updateBoard(int boardNo);
	
	public void deleteBoard(int boardNo);
	
	public void searchBoard();
	
}
