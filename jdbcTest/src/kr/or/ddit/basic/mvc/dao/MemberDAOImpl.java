package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.basic.DbUtil3;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberDAOImpl implements IMemeberDAO {

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

		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if (statement != null) {try {statement.close();} catch (SQLException e) {}}
			if (connection != null) {try {connection.close();} catch (Exception e) {}}
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
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if (statement != null) try {statement.close();} catch (SQLException e) {}
			if (connection != null) try {connection.close();} catch (Exception e) {}
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
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if (statement != null) try {statement.close();} catch (SQLException e) {}
			if (connection != null) try {connection.close();} catch (Exception e) {}
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
		} catch (SQLException e) {
			e.printStackTrace();
			memberList = null;
		} finally {
			if (statement != null) try {statement.close();} catch (SQLException e) {}
			if (connection != null) try {connection.close();} catch (Exception e) {}
			if (result != null) try {result.close();}catch(Exception e) {}
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
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		} finally {
			if (statement != null) try {statement.close();} catch (SQLException e) {}
			if (connection != null) try {connection.close();} catch (Exception e) {}
			if (result != null) try {result.close();}catch(Exception e) {}
		}
		return cnt;
	}

}
