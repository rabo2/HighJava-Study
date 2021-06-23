package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//dbinfo.properties파일의 내용을 읽어서 설정하는 방법
//방법1) Properties객체 이용하기
import java.util.Properties;

public class DbUtil2 {
	static Properties prop; // Properties 객체변수 선언

	static { // static 초기화 블럭
		prop = new Properties();// Properties 객체 생성

		File file = new File("res/kr/or/ddit/config/dbinfo.properties");
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(file); // 입력스트림 객체 생성
			prop.load(fin); // 파일 내용 읽어와 추가하기

			// Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName(prop.getProperty("driver"));
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
	}

	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(prop.getProperty("url"),
											   prop.getProperty("user"),
											   prop.getProperty("pass"));

		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
			return null;
		}
	}
}
