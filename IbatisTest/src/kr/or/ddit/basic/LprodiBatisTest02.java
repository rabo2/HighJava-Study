package kr.or.ddit.basic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LprodiBatisTest02 {
	/*
	 * LPROD테이블에 새로운 데이터 추가하기
	 * 
	 * 상품분류코드(lprod_gu), 상품분류명(lprod_nm)은 직접 입력받아서 처리하고, Lprod_id는 현재 lprod_id중 제일
	 * 큰값보다 1크게한다. 그리고 입력받은 상품분류코드(lprod_gu)가 이미등록되어 있으면 다시 입력받아서 처리한다.
	 */
	
	/*
	 * 
	 * 
	 */
	private Scanner scan;

	public static void main(String[] args) {
		new LprodiBatisTest02().insert();
	}

	public LprodiBatisTest02() {
		scan = new Scanner(System.in);
	}

	private void insert() {
		String sql = "INSERT INTO LPROD(LPROD_ID, LPROD_GU, LPROD_NM)"
				+ " VALUES((SELECT MAX(LPROD_ID)+1 FROM LPROD), ?, ?)";
		PreparedStatement statement = DbUtil.dbConnect(sql);
		try {
			String lprodGu;
			while (true) {
				System.out.print("상품 코드 입력(LPROD_GU) : ");
				lprodGu = scan.next();
				if (guCheck(lprodGu) == 1) {
					System.out.println("이미 존재하는 상품입니다.");
				} else {
					break;
				}
			}
			String lprodName;
			while (true) {
				System.out.print("상품 이름 입력(LPROD_NM) : ");
				lprodName = scan.next();
				if (nameCheck(lprodName) == 1) {
					System.out.println("이미 존재하는 상품 이름입니다.");
				} else {
					break;
				}
			}
			statement.setString(1, lprodGu);
			statement.setString(2, lprodName);

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
			DbUtil.dbClose();
		}
	}

	private int guCheck(String lprodGu) {
		String sql = "SELECT COUNT(*) FROM LPROD WHERE LPROD_GU = ?";
		int count = 0;
		try {
			PreparedStatement statement = DbUtil.dbConnect(sql);
			statement.setString(1, lprodGu);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				count = result.getInt("COUNT(*)");
			}
		} catch (Exception e) {

		} finally {
			DbUtil.dbClose();
		}
		return count;
	}

	private int nameCheck(String lprodName) {
		String sql = "SELECT COUNT(*) FROM LPROD WHERE LPROD_NM = ?";
		int count = 0;
		try {
			PreparedStatement statement = DbUtil.dbConnect(sql);
			statement.setString(1, lprodName);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				count = result.getInt("COUNT(*)");
			}
		} catch (Exception e) {

		} finally {
			DbUtil.dbClose();
		}
		return count;
	}

}