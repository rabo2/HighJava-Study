package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcTest05 {
	/*
	 * LPROD테이블에 새로운 데이터 추가하기
	 * 
	 * 상품분류코드(lprod_gu), 상품분류명(lprod_nm)은 직접 입력받아서 처리하고, Lprod_id는 현재 lprod_id중 제일
	 * 큰값보다 1크게한다. 그리고 입력받은 상품분류코드(lprod_gu)가 이미등록되어 있으면 다시 입력받아서 처리한다.
	 */

	private Connection connection;
	private PreparedStatement statement;
	private Scanner scan;

	public JdbcTest05() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KMS96", "java");
			scan = new Scanner(System.in);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		new JdbcTest05().insert();
	}

	private void insert() {
		String sql = "INSERT INTO LPROD(LPROD_ID, LPROD_GU, LPROD_NM) VALUES(?, ?, ?)";
		try {
			String lprodGu;
			while (true) {
				System.out.print("상품 코드 입력 : ");
				lprodGu = scan.next();
				if (guCheck(lprodGu) == 1) {
					System.out.println("이미 존재하는 상품입니다.");
				} else {
					break;
				}
			}
			String lprodName;
			while (true) {
				System.out.print("상품 이름 입력 :");
				lprodName = scan.next();
				if (nameCheck(lprodName) == 1) {
					System.out.println("이미 존재하는 상품 이름입니다.");
				} else {
					break;
				}
			}
			int max = searchMax();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, max);
			statement.setString(2, lprodGu);
			statement.setString(3, lprodName);

			int count = statement.executeUpdate();

			if (count > 0) {
				System.out.println("상품이 등록되었습니다.");
			} else {
				System.out.println("상품등록 실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null)
				try {
					statement.close();
				} catch (Exception e) {
				}
			if (connection != null)
				try {
					connection.close();
				} catch (Exception e) {
				}
		}
	}

	private int guCheck(String lprodGu) {
		String sql = "SELECT COUNT(*) FROM LPROD WHERE LPROD_GU = ?";
		int count = 0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, lprodGu);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				count = result.getInt("COUNT(*)");
			}
		} catch (Exception e) {

		}
		return count;
	}

	private int nameCheck(String lprodName) {
		String sql = "SELECT COUNT(*) FROM LPROD WHERE LPROD_NM = ?";
		int count = 0;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, lprodName);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				count = result.getInt("COUNT(*)");
			}
		} catch (Exception e) {

		}
		return count;
	}

	private int searchMax() {
		String sql = "SELECT MAX(LPROD_ID) FROM LPROD";
		int max = 0;
		try {
			statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				max = result.getInt("MAX(LPROD_ID)");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return max + 1;
	}

}
