package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class DbUtil3 {
	static ResourceBundle bundle;
	//현재 클래스의 이름을 기술
	static final Logger	logger = Logger.getLogger(DbUtil3.class);
	
	static { // static 초기화 블럭
		bundle = ResourceBundle.getBundle("kr.or.ddit.config.dbinfo");
		logger.info("properties파일을 이용한 ResourceBundle객체 생성");
		
		try {
			Class.forName(bundle.getString("driver"));
			logger.info("DB 드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			logger.error("DB 드라이버 로딩 실패" + e);
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			 conn = DriverManager.getConnection(
					bundle.getString("url"), 
					bundle.getString("user"),
					bundle.getString("pass"));
			 logger.info("DB 시스템에 연결 성공");
			 return conn;
		} catch (SQLException e) {
			logger.error("DB 시스템에 연결 실패" + e);
			return null;
		}
	}
}
