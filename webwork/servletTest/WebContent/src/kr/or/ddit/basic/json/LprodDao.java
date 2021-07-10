package kr.or.ddit.basic.json;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.util.DBUtil;

public class LprodDao {
	private static LprodDao dao;

	private LprodDao() {
	}

	public static LprodDao getInstance() {
		if (dao == null)
			dao = new LprodDao();
		return dao;
	}

	public List<LprodVO> getLprodList() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<LprodVO> lprodList = new ArrayList<LprodVO>();
		try {
			con = DBUtil.getConnection();
			String sql = "select * from lprod";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				LprodVO vo = new LprodVO();
				vo.setLprod_id(rs.getInt("lprod_id"));
				vo.setLprod_nm(rs.getString("lprod_nm"));
				vo.setLprod_gu(rs.getString("lprod_gu"));
				lprodList.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
				}

		}
		return lprodList;

	}
}
