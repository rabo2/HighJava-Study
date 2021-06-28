package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.JdbcBoardDAO;
import kr.or.ddit.board.dao.JdbcBoardDAOIF;
import kr.or.ddit.board.vo.JdbcBoardVO;

public class JdbcBoardService implements JdbcBoardDAOIF {
	private static JdbcBoardService service;
	private JdbcBoardDAO dao;

	private JdbcBoardService() {
		dao = JdbcBoardDAO.getInstance();
	}

	public static JdbcBoardService getInstance() {
		if (service == null) {
			service = new JdbcBoardService();
		}
		return service;
	}

	@Override
	public int insertNewBoard(JdbcBoardVO jdbcBoardVO) {
		return dao.insertNewBoard(jdbcBoardVO);
	}

	@Override
	public List<JdbcBoardVO> displayAllBoard() {
		// TODO Auto-generated method stub
		return dao.displayAllBoard();
	}

	@Override
	public JdbcBoardVO showBoard(int boardNo) {
		int count = increaseCount(boardNo);
		if (count > 0) {
			return dao.showBoard(boardNo);
		} else {
			return null;
		}
	}

	@Override
	public int deleteBoard(int boardNo) {
		// TODO Auto-generated method stub
		return dao.deleteBoard(boardNo);
	}

	@Override
	public List<JdbcBoardVO> searchBoard(String title) {
		// TODO Auto-generated method stub
		return dao.searchBoard(title);
	}

	@Override
	public int updateBoard(JdbcBoardVO jdbcBoardVO) {
		// TODO Auto-generated method stub
		return dao.updateBoard(jdbcBoardVO);
	}

	@Override
	public int increaseCount(int boardNo) {
		int count = dao.increaseCount(boardNo);
		return count;
	}

	@Override
	public int checkTitle(String title) {
		return dao.checkTitle(title);
	}

}
