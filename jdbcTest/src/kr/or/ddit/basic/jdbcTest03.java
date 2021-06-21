package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class jdbcTest03 {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		Scanner scanner = new Scanner(System.in);
		String[] arr = new String[2];
		for(int i = 0; i < arr.length; i++) {
			System.out.println((i+1)+"번째 값 입력");
			arr[i] = scanner.next();
		}
		Arrays.sort(arr);
		String sql = "SELECT * FROM LPROD WHERE LPROD_ID > ? AND LPROD_ID < ?";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","KMS96", "java");
			statement = connection.prepareStatement(sql);
			statement.setString(1, arr[0]);
			statement.setString(2, arr[1]);
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
