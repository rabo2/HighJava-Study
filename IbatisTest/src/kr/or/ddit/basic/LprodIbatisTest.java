package kr.or.ddit.basic;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class LprodIbatisTest {
	// iBatis를 이용하여 DB자료를 처리하는 순서 및 방법
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// 1. iBatis의 환경설정파일(sqlMapConfig.xml)을 읽어와 실행한다.
		try {
			// 1-1. 문자 인코딩 캐릭터셋 설정
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);

			// 1-2. 환경 설정 파일을 읽어온다.
			Reader rd = Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");
			// 1-3. 위에서 읽어온 Reader객체를 이용하여 실제 환경 설정을 완성한 후
			// 작성된 SQL문을 호출해서 처리할 객체를 생성한다.
			SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);

			// Reader객체 닫기
			rd.close();

			// ------------------------------------------------------------------------------

			// 2. 실행할 SQL문에 맞는 쿼리문을 호출해서 원하는 작업을 수행한다.

			// 2-1. insert 연습
			/*
			System.out.println("insert 작업 시작...");
			System.out.print("lprod_id 입력  : ");
			int lprodId = scan.nextInt();

			System.out.print("lprod_gu 입력 : ");
			String lprodGu = scan.next();

			System.out.print("lprod_nm 입력 : ");
			String lprodNm = scan.next();

			// 1) 저장할 데이터를 VO객체에 저장한다.
			LprodVO vo = new LprodVO();
			vo.setLprod_id(lprodId);
			vo.setLprod_gu(lprodGu);
			vo.setLprod_nm(lprodNm);

			// 2) SqlMapClient 객체변수를 이용해서 처리할 쿼리문을 호출하여 실행한다.
			// 형식) smc.insert("namespace속성값.id속성값", 파라미터클래스);
			// 반환값 : insert 성공 : null, 실패 : 오류객체(주의)
			Object obj = smc.insert("lprod.insertLprod", vo);
			if (obj == null) {
				System.out.println("insert 작업 성공");
			} else {
				System.out.println("insert 작업 실패");
			}
			*/
			
			/*
			// 2-2 update연습
			System.out.println("update 작업 시작...");
			System.out.print("수정할 lprod_id 입력  : ");
			int lprodId2 = scan.nextInt();

			System.out.print("수정할 lprod_gu 입력 : ");
			String lprodGu2 = scan.next();

			System.out.print("수정할 lprod_nm 입력 : ");
			String lprodNm2 = scan.next();

			// 1) 저장할 데이터를 VO객체에 저장한다.
			LprodVO vo2 = new LprodVO();
			vo2.setLprod_id(lprodId2);
			vo2.setLprod_gu(lprodGu2);
			vo2.setLprod_nm(lprodNm2);

			// 2) 형식) smc.update("namespace속성값.id속성값", 파라미터클래스)
			// 반환값 : 작업에 성공한 레코드 수
			int count = smc.update("lprod.updateLprod", vo2);
			if (count > 0) {
				System.out.println("update 성공");
			} else {
				System.out.println("update 실패");
			}
			*/
			
			/*
			// 2-3. delete 연습
			System.out.println("delete 작업 시작");
			System.out.print("삭제할 lprod_gu 입력 : ");
			String lprodGu3 = scan.next();
			
			//형식) smc.delete("namespace속성값.id속성값", 파라미터클래스);
			//		반환값 : 작업에 성공한 레코드 수
			int count = smc.delete("lprod.deleteLprod", lprodGu3);
			if(count > 0) {
				System.out.println("삭제 성공");
			}else {
				System.out.println("삭제 실패");
			}
			*/
			
			//2-4. select 연습
			System.out.println("select 작업 시작");
			/*
			//1) 응답의 결과가 여러개의 레코드 일 경우
			System.out.println("1) 응답 결과가 여러개의 레코드일 경우");
			//형식) smc.queryForList("namespace 속성값.id 속성값", 파라미터클래스);
			// 	=> queryForList()메소드는 여러개의 레코드 각각을 VO에 담은 후 이  VO데이터를 List에 추가해 주는
			//		작업을 자동으로 수행한다.
			
			List<LprodVO> list = smc.queryForList("lprod.getAllLprod");
			for (LprodVO vo : list) {
				System.out.println("Lprod_id : " +  vo.getLprod_id());
				System.out.println("Lprod_gu : " + vo.getLprod_gu());
				System.out.println("Lprod_nm : " + vo.getLprod_nm());
				System.out.println("------------------------");
			}
			*/
			//2) 응답의 결과가 한개의 레코드 일경우
			// 형식) smc.queryForObject("namespace속성값.id속성값", 파라미터클래스);
			//		반환 값 : 쿼리 결과가 여러개일 경우 ==> 오류 발생
			//			    1개일 경우 ==> 해당 객체 반환
			//				없을 경우 ==> null 반환
			
			System.out.println("2) 응답의 결과가 한개의 레코드 일경우");
			String lprodGu3 = scan.next();
			LprodVO vo = (LprodVO) smc.queryForObject("lprod.getLprod", lprodGu3);
			if(vo == null) {
				System.out.println("검색한 데이터가 존재하지 않습니다.");
				return;
			}
			
			System.out.println("Lprod_id : " +  vo.getLprod_id());
			System.out.println("Lprod_gu : " + vo.getLprod_gu());
			System.out.println("Lprod_nm : " + vo.getLprod_nm());
			
			System.out.println("출력 끝");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
