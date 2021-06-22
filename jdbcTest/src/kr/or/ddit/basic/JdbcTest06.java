package kr.or.ddit.basic;
/*
 * 회원 관리 프로그램을 작성하시오.(MYMEMBER 테이블 이용)
 * 아래 메뉴의 기능을 모두 구현하시오
 * 
 * Ex)
 * -- 작업 선택 --
 * 1. 자료 추가
 * 2. 자료 삭제
 * 3. 자료 수정
 * 4. 전체 자료 출력
 * 0. 작업 끝
 * --------------
 * 작업 선택 >
 * 
 * 처리조건) 
 * 1. 자료 추가에서 '회원 ID'는 중복되지 않는다.(중복시 다시 입력)
 * 2. 자료 삭제는 '회원ID'를 입력받아서 처리한다.
 * 3. 자료 수정에서는 '회원ID'는 변경하지 않는다.
 * 
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class JdbcTest06 {
	private Scanner scan;

	public static void main(String[] args) {
		new JdbcTest06().console();

	}

	public JdbcTest06() {
		scan = new Scanner(System.in);

	}

	private int mainPage() {
		System.out.println("---작업 선택 ---");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 전체 자료 출력");
		System.out.println("0. 작업 끝");
		System.out.println("------------");
		System.out.print("작업 선택 > ");
		return scan.nextInt();
	}

	private void console() {
		while (true) {
			int inputNum = mainPage();
			switch (inputNum) {
			case 1:
				createData();
				break;
			case 2:
				deleteData();
				break;
			case 3:
				updateData();
				break;
			case 4:
				printAllData();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다");
				scan.close();
				System.exit(0);
			default:
				break;
			}
		}
	}

	private void createData() {
		String sql = "INSERT INTO MYMEMBER" + " VALUES(?, ?, ?, ?, ?)";
		PreparedStatement statement = DbUtil.dbConnect(sql);
		String id;
		while (true) {
			System.out.print("ID 입력 : ");
			id = scan.next();
			if (idCheck(id) > 0) {
				System.out.println("이미 존재하는 ID입니다.");
			} else {
				break;
			}
		}
		System.out.print("PASSWORD 입력 : ");
		String pass = scan.next();
		System.out.print("이름 입력 : ");
		String name = scan.next();

		boolean regex;
		String tel = "";
		while (true) {
			System.out.print("전화번호 입력 : ");
			tel = scan.next();
			String pattern = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
			regex = Pattern.matches(pattern, tel);
			if (regex) {
				break;
			} else {
				System.out.println("전화번호 형식이 틀렸습니다.");
			}
		}

		System.out.print("주소 입력 : ");
		String addr = scan.next();
		try {
			statement.setString(1, id);
			statement.setString(2, pass);
			statement.setString(3, name);
			statement.setString(4, tel);
			statement.setString(5, addr);
			int result = statement.executeUpdate();
			if (result > 0) {
				System.out.println("등록이 완료 되었습니다.");
			} else {
				System.out.println("등록 실패");
			}
		} catch (Exception e) {
		} finally {
			DbUtil.dbClose();
		}
	}

	private int idCheck(String id) {
		String sql = "SELECT COUNT(*) FROM MYMEMBER WHERE MEM_ID = ?";
		PreparedStatement statement = DbUtil.dbConnect(sql);
		int count = 0;
		ResultSet result = null;
		try {
			statement.setString(1, id);
			result = statement.executeQuery();
			if (result.next()) {
				count = result.getInt("COUNT(*)");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			DbUtil.dbClose();

		}
		return count;
	}

	private void deleteData() {
		String sql = "DELETE MYMEMBER WHERE MEM_ID = ?";
		PreparedStatement statement = DbUtil.dbConnect(sql);
		String id = "";
		while (true) {
			System.out.print("삭제할 ID입력 : ");
			id = scan.next();
			if (idCheck(id) == 0) {
				System.out.println("존재하지 않는 ID입니다.");
			} else {
				break;
			}
		}
		try {
			statement.setString(1, id);
			int result = statement.executeUpdate();
			if (result > 0) {
				System.out.println("삭제 완료");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtil.dbClose();
		}
	}

	private void updateData() {
		String sql = "UPDATE MYMEMBER SET MEM_PASS = ?, MEM_NAME = ?, MEM_TEL = ?, MEM_ADDR = ?" + " WHERE MEM_ID = ?";
		PreparedStatement statement = DbUtil.dbConnect(sql);
		String id = "";
		while (true) {
			System.out.print("수정할 ID 입력 : ");
			id = scan.next();
			if (idCheck(id) == 0) {
				System.out.println("존재하지 않는 ID입니다.");
			} else {
				break;
			}
		}
		System.out.print("변경할 Password 입력 : ");
		String pass = scan.next();
		System.out.print("변경할 이름 입력 : ");
		String name = scan.next();
		System.out.print("변경할 전화번호 입력 : ");
		String tel = scan.next();
		System.out.print("변경할 주소 입력 : ");
		String addr = scan.next();
		try {
			statement.setString(1, pass);
			statement.setString(2, name);
			statement.setString(3, tel);
			statement.setString(4, addr);
			statement.setString(5, id);
			int result = statement.executeUpdate();
			if (result > 0) {
				System.out.println("회원정보 수정완료");
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			DbUtil.dbClose();
		}
	}

	private void printAllData() {
		String sql = "SELECT * FROM MYMEMBER";
		PreparedStatement statement = DbUtil.dbConnect(sql);
		ResultSet result = null;
		try {
			result = statement.executeQuery();
			System.out.println("--------------------회원 목록--------------------");
			System.out.println("ID\tPASS\t이름\t전화번호\t\t주소");
			while (result.next()) {
				String id = result.getString("MEM_ID");
				String pass = result.getString("MEM_PASS");
				String name = result.getNString("MEM_NAME");
				String tel = result.getNString("MEM_TEL");
				String addr = result.getNString("MEM_ADDR");
				System.out.println(id + "\t" + pass + "\t" + name + "\t" + tel + "\t" + addr);
			}
			System.out.println("------------------------------------------------");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			DbUtil.dbClose();
		}
	}

}
