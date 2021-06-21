package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcTest04 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KMS96", "java");
			System.out.println("계좌번호 정보 추가하기");
			System.out.print("계좌번호 : ");
			String bankNo = scan.next();
			System.out.print("은 행 명 : ");
			String bankName = scan.next();
			System.out.print("예 금 주 명 : ");
			String bankUser = scan.next();

			String sql = "insert into bankinfo(bank_no, bank_name, bank_user_name, bank_date)"
					+ " values(?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bankNo);
			pstmt.setString(2, bankName);
			pstmt.setString(3, bankUser);

			int cnt = pstmt.executeUpdate();

			System.out.println("반환값 : " + cnt);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (pstmt != null || conn != null) {
				try {
					pstmt.close();
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

		}
	}
}
