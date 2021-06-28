package kr.or.ddit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.board.vo.JdbcBoardVO;

public class JdbcBoardDAO implements JdbcBoardDAOIF {
	private static JdbcBoardDAO dao;
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet result;
	
	private void disConnect() {
		if (result != null) {try {result.close();} catch (SQLException e) {}}
		if (statement != null) {try {statement.close();} catch (SQLException e) {}}
		if (connection != null) {try {connection.close();} catch (SQLException e) {}}
		
	}
	
	
	private JdbcBoardDAO() {
		
	}

	public static JdbcBoardDAO getInstance() {
		if (dao == null) {
			dao = new JdbcBoardDAO();
		}
		return dao;
	}

	
	@Override
	public int insertNewBoard(JdbcBoardVO jdbcBoardVO) {
		int count = 0;
		String sql = "INSERT INTO JDBC_BOARD VALUES (BOARD_SEQ.NEXTVAL,?,?,SYSDATE,0,?)";
		try {
			connection = DbUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, jdbcBoardVO.getBoard_title());
			statement.setString(2, jdbcBoardVO.getBoard_writer());
			statement.setString(3, jdbcBoardVO.getBoard_content());
			count = statement.executeUpdate();
		} catch (Exception e) {
			count = 0;
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return count;
	}

	@Override
	public List<JdbcBoardVO> displayAllBoard() {
		List<JdbcBoardVO> voList = new ArrayList<>();
		String sql = "SELECT * FROM JDBC_BOARD ORDER BY BOARD_NO DESC";
		
		try {
			connection = DbUtil.getConnection();
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			while(result.next()) {
				JdbcBoardVO vo = new JdbcBoardVO();
				vo.setBoard_no(result.getInt("BOARD_NO"));
				vo.setBoard_title(result.getString("BOARD_TITLE"));
				vo.setBoard_writer(result.getString("BOARD_WRITER"));
				vo.setBoard_date(result.getString("BOARD_DATE"));
				vo.setBoard_cnt(result.getInt("BOARD_CNT"));
				vo.setBoard_content(result.getString("BOARD_CONTENT"));
				voList.add(vo);
			}
		} catch (Exception e) {
			voList = null;
		} finally {
			disConnect();
		}
		return voList;
	}
	
	@Override
	public JdbcBoardVO showBoard(int boardNo) {
		JdbcBoardVO vo = null;
		String sql = "SELECT * FROM JDBC_BOARD WHERE BOARD_NO = ?";
		try {
			connection = DbUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, boardNo);
			result = statement.executeQuery();
			if(result.next()) {
				vo = new JdbcBoardVO();
				vo.setBoard_no(result.getInt("BOARD_NO"));
				vo.setBoard_title(result.getString("BOARD_TITLE"));
				vo.setBoard_writer(result.getString("BOARD_WRITER"));
				String date = result.getString("BOARD_DATE");
				date = date.substring(0, 11);
				vo.setBoard_date(date);
				vo.setBoard_cnt(result.getInt("BOARD_CNT"));
				vo.setBoard_content(result.getString("BOARD_CONTENT"));
			}
		} catch (Exception e) {
			vo = null;
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return vo;
	}

	@Override
	public int updateBoard(JdbcBoardVO jdbcBoardVO) {
		int count = 0;
		String sql = "UPDATE JDBC_BOARD SET BOARD_TITLE = ?, BOARD_CONTENT = ?, BOARD_DATE = SYSDATE WHERE BOARD_NO = "
				+ " (SELECT BOARD_NO FROM JDBC_BOARD WHERE BOARD_NO = ?)";
		try {
			connection = DbUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, jdbcBoardVO.getBoard_title());
			statement.setString(2, jdbcBoardVO.getBoard_content());
			statement.setInt(3, jdbcBoardVO.getBoard_no());
			count = statement.executeUpdate();
		} catch (Exception e) {
			count = 0;
		} finally {
			disConnect();
		}
		return count;
	}

	@Override
	public int deleteBoard(int boardNo) {
		int count = 0;
		String sql = "DELETE JDBC_BOARD WHERE BOARD_NO = ?";
		try {
			connection = DbUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, boardNo);
			count = statement.executeUpdate();
		} catch (Exception e) {
			count = 0;
		} finally {
			disConnect();
		}
		return count;
	}
	
	@Override
	public List<JdbcBoardVO> searchBoard(String title) {
		List<JdbcBoardVO> list = new ArrayList<>();
		String sql = "SELECT * FROM JDBC_BOARD WHERE BOARD_TITLE LIKE ?";
		try {
			connection = DbUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, "%"+title+"%");
			result = statement.executeQuery();
			while(result.next()) {
				JdbcBoardVO vo = new JdbcBoardVO();
				vo.setBoard_no(result.getInt("BOARD_NO"));
				vo.setBoard_title(result.getString("BOARD_TITLE"));
				vo.setBoard_writer(result.getString("BOARD_WRITER"));
				vo.setBoard_date(result.getString("BOARD_DATE"));
				vo.setBoard_cnt(result.getInt("BOARD_CNT"));
				vo.setBoard_content(result.getString("BOARD_CONTENT"));
				list.add(vo);
			}

		} catch (Exception e) {
			list = null;
		} finally {
			disConnect();
		}
		return list;
	}

	@Override
	public int increaseCount(int boardNo) {
		String sql = "UPDATE JDBC_BOARD SET BOARD_CNT = BOARD_CNT+1 WHERE BOARD_NO = ?";
		int count = 0;
		try {
			connection = DbUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, boardNo);
			count = statement.executeUpdate();
		} catch (Exception e) {
		} finally {
			disConnect();
		}
		return count;
	}

	@Override
	public int checkTitle(String title) {
		int count = 0;
		String sql = "SELECT COUNT(*) FROM JDBC_BOARD WHERE BOARD_TITLE = ?";
		try {
			connection = DbUtil.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setNString(1, title);
			result = statement.executeQuery();
			if(result.next()) {
				count = result.getInt("COUNT(*)");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			disConnect();
		}
		return count;
	}

}
