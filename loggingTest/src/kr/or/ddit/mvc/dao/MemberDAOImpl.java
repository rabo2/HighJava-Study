package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import kr.or.ddit.util.DbUtil3;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberDAOImpl implements IMemeberDAO {
	private static final Logger logger = Logger.getLogger(MemberDAOImpl.class);

	private static MemberDAOImpl dao;

	private MemberDAOImpl() {
	}

	public static MemberDAOImpl getInstance() {
		if (dao == null)
			dao = new MemberDAOImpl();
		return dao;
	}

	@Override
	public int insertMember(MemberVO memberVO) {
		int cnt = 0; // 반환값이 저장될 변수
		Connection connection = null;
		PreparedStatement statement = null;
		try {

			String sql = "INSERT INTO MYMEMBER" + " VALUES(?, ?, ?, ?, ?)";
			connection = DbUtil3.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, memberVO.getMemId());
			statement.setString(2, memberVO.getMemPass());
			statement.setString(3, memberVO.getMemName());
			statement.setString(4, memberVO.getMemTel());
			statement.setString(5, memberVO.getMemAddr());
			cnt = statement.executeUpdate();

			logger.info("PrepareStatement객체 생성");
			logger.info("실행 SQL : " + sql);
			logger.info("사용데이터 : [" + memberVO.getMemId() + ", " 
									 + memberVO.getMemPass() + ", " 
									 + memberVO.getMemName()+ ", " 
									 + memberVO.getMemTel() + ", " 
									 + memberVO.getMemAddr()
									 +"]");
		} catch (SQLException e) {
			logger.error("insert작업 실패 "+e);
			cnt = 0;
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
					logger.info("PrepareStatement객체 반납 성공");
				} catch (SQLException e) {
				}
			}
			if (connection != null) {
				try {
					connection.close();
					logger.info("Connection객체 반납 성공");
				} catch (Exception e) {
				}
			}
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		Connection connection = null;
		PreparedStatement statement = null;
		int cnt = 0;
		try {
			String sql = "DELETE MYMEMBER WHERE MEM_ID = ?";
			connection = DbUtil3.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, memId);
			cnt = statement.executeUpdate();
			logger.info("PrepareStatement객체 생성");
			logger.info("실행 SQL : " + sql);
			logger.info("사용데이터 : "+memId);
		} catch (Exception e) {
			logger.error("delete 구문 실행 실패" + e);
			cnt = 0;
			e.printStackTrace();
		} finally {
			if (statement != null)
				try {
					statement.close();
					logger.info("PrepareStatement객체 반납 성공");
				} catch (SQLException e) {
				}
			if (connection != null)
				try {
					connection.close();
					logger.info("Connection객체 반납 성공");
				} catch (Exception e) {
				}
		}
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memberVO) {
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "UPDATE MYMEMBER SET MEM_PASS = ?, MEM_NAME = ?, MEM_TEL = ?, MEM_ADDR = ?" + " WHERE MEM_ID = ?";
		int cnt = 0;
		try {
			connection = DbUtil3.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, memberVO.getMemId());
			statement.setString(2, memberVO.getMemPass());
			statement.setString(3, memberVO.getMemName());
			statement.setString(4, memberVO.getMemTel());
			statement.setString(5, memberVO.getMemAddr());
			cnt = statement.executeUpdate();
			logger.info("PrepareStatement객체 생성");
			logger.info("실행 SQL : " + sql);
			logger.info("사용데이터 : [" + memberVO.getMemId() + ", " 
									 + memberVO.getMemPass() + ", " 
									 + memberVO.getMemName()+ ", " 
									 + memberVO.getMemTel() + ", " 
									 + memberVO.getMemAddr()
									 +"]");
		} catch (Exception e) {
			logger.error("update 구문 실행 실패"+e);
			cnt = 0;
			e.printStackTrace();
		} finally {
			if (statement != null)
				try {
					statement.close();
					logger.info("PrepareStatement객체 반납 성공");
				} catch (SQLException e) {
				}
			if (connection != null)
				try {
					connection.close();
					logger.info("Connection객체 반납 성공");
				} catch (Exception e) {
				}
		}
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		String sql = "SELECT * FROM MYMEMBER";
		try {
			connection = DbUtil3.getConnection();
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			while (result.next()) {
				MemberVO vo = new MemberVO();
				vo.setMemId(result.getString("MEM_ID"));
				vo.setMemPass(result.getString("MEM_PASS"));
				vo.setMemName(result.getString("MEM_NAME"));
				vo.setMemTel(result.getString("MEM_TEL"));
				vo.setMemAddr(result.getString("MEM_ADDR"));
				memberList.add(vo);
			}
			logger.info("PrepareStatement객체 생성");
			logger.info("실행 SQL : " + sql);
		} catch (SQLException e) {
			logger.error("select 실행 실패" + e);
			memberList = null;
		} finally {
			if (statement != null)
				try {
					statement.close();
					logger.info("PrepareStatement객체 반납 성공");
				} catch (SQLException e) {
				}
			if (connection != null)
				try {
					connection.close();
					logger.info("Connection객체 반납 성공");
				} catch (Exception e) {
				}
			if (result != null)
				try {
					result.close();
					logger.info("ResultSet객체 반납 성공");
				} catch (Exception e) {
				}
		}
		return memberList;
	}

	@Override
	public int getMeberCount(String memId) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		int cnt = 0;
		String sql = "SELECT COUNT(*) FROM MYMEMBER WHERE MEM_ID = ?";
		try {
			connection = DbUtil3.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, memId);
			result = statement.executeQuery();
			if (result.next()) {
				cnt = result.getInt("COUNT(*)");
			}
			logger.info("PrepareStatement객체 생성");
			logger.info("실행 SQL : " + sql);
			logger.info("사용데이터 :" + memId);
			
		} catch (Exception e) {
			logger.error("select 실행 실패" + e);
			cnt = 0;
		} finally {
			if (statement != null)
				try {
					statement.close();
					logger.info("PrepareStatement객체 반납 성공");
				} catch (SQLException e) {
				}
			if (connection != null)
				try {
					connection.close();
					logger.info("Connection객체 반납 성공");
				} catch (Exception e) {
				}
			if (result != null)
				try {
					result.close();
					logger.info("ResultSet객체 반납 성공");
				} catch (Exception e) {
				}
		}
		return cnt;
	}

	// @Override
	// public int updateMember2(String dataType, String updateData, String memId) {
	// int count = 0;
	// Connection connection = null;
	// PreparedStatement statement = null;
	// String sql = "UPDATE MYMEMBER SET " + dataType + " = ? WHERE MEM_ID = ?";
	// try {
	// connection = DbUtil3.getConnection();
	// statement = connection.prepareStatement(sql);
	// statement.setString(1, updateData);
	// statement.setNString(2, memId);
	// count = statement.executeUpdate();
	// } catch (SQLException e) {
	// count = 0;
	// } finally {
	// if (statement != null) try {statement.close();} catch (SQLException e) {}
	// if (connection != null) try {connection.close();} catch (Exception e) {}
	// }
	// return count;
	// }

	@Override
	public int updateMember2(Map<String, String> paraMap) {
		int count = 0;
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "UPDATE MYMEMBER SET " + paraMap.get("field") + " = ? WHERE MEM_ID = ?";
		try {
			connection = DbUtil3.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, paraMap.get("data"));
			statement.setNString(2, paraMap.get("memId"));
			count = statement.executeUpdate();
		} catch (SQLException e) {
			count = 0;
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (SQLException e) {
				}
			if (connection != null)
				try {
					connection.close();
				} catch (Exception e) {
				}
		}
		return count;
	}

}
