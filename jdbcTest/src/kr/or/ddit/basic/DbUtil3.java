package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DbUtil3 {
	static ResourceBundle bundle;

	static { // static 초기화 블럭
		bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");
		try {
			Class.forName(bundle.getString("driver"));
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(
					bundle.getString("url"), 
					bundle.getString("user"),
					bundle.getString("pass"));

		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
			return null;
		}
	}
}
