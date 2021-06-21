package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//문제) 사용자로부터 Lprod_id값을 입력받아 입력한 값보다 Lprod_id 값이 큰 자료를 출력하시오
public class jdbcTest02 {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("id번호를 입력");
		String input = scanner.next();
		String sql = "SELECT * FROM LPROD WHERE LPROD_ID > ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KMS96", "java");
			statement = connection.prepareStatement(sql);
			statement.setString(1, input);
			result = statement.executeQuery();
			while (result.next()) {
				System.out.println("Lprod_id : " + result.getInt("lprod_id"));
				System.out.println("Lprod_gu : " + result.getString(2));
				System.out.println("Lprod_nm : " + result.getString("LPROD_NM"));
				System.out.println("--------------------------------");
			}
		} catch (Exception e) {
		} finally {
			if (result != null) try {result.close();} catch (SQLException e) {}
			if (statement != null) try {statement.close();} catch (SQLException e) {}
			if (connection != null) try {connection.close();} catch (SQLException e) {}
		}

	}
}
