package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.MemberVO;

/**
 * Service객체는 DAO에 설정된 메소드를 원하는 작업에 맞게 호출하여
 * 결과를 받아오고, 받아온 결과 자료를 Controller에게 보내주는 역활을 한다.
 * 보통 DAO의 메소드 구조와 같게 만든다.
 * @author PC-05
 *
 */
public interface IMemberService {
		/**
		 * MemberVO에 담겨진 데이터를 DB에 insert하는 메소드
		 * @param memberVO DB에 insert할 자료가 저장될 MemberVO객체
		 * @return 작업성공 여부 성공시  1이상, 실패 시 0 으로 반환한다.
		 */
		public int insertMember(MemberVO memberVO);

		
		/**
		 * 화원 ID를 매개변수로 받아서 해당 회원 정보를 삭제하는 메서드
		 * @param memId 삭제할 회원 ID
		 * @return 작업 성공 : 1, 작업 실패 : 0
		 */
		public int deleteMember(String memId);
		
		/**
		 * MemberVO자료를 이용하여 DB에 update하는 메소드
		 * @param memberVO update할 회원정보가 저장된 MemberVO객체
		 * @return 작업 성공  : 1, 작업 실패 : 0
		 */
		public int updateMember(MemberVO memberVO);
		
		
		/**
		 * DB의 회원 테이블의 전체 레코드를 가져와서 List에 담아서 반환하는 메소드
		 * @return 검색된 데이터가 저장된 List객체
		 */
		public List<MemberVO> getAllMemberList();
		
		/**
		 * 회원 ID를 매개변수로 받아서 해당 회원의 개수를 반환하는 메소드
		 * @param memId 검색할 회원 ID
		 * @return 검색된 회원의 갯수
		 */
		public int getMeberCount(String memId);
		
		/**
		 * 회원 ID와 수정할 데이터 종류, 수정될 데이터를 매개변수로 받아 회원의 정보를 부분수정하는 메소드
		 * @param data 수정할 데이터 종류
		 * @param updateData 새로 입력할 데이터
		 * @param memId 회원ID
		 * @return 작업 성공  : 1, 작업 실패 : 0
		 */
//		public int updateMember2(String dataType, String updateData, String memId);
	
		/**
		 * Map의 정보를 이용하여 회원 정보 중 원하는 컬럼을 수정하는 메소드
		 * key값 정보 => 회원 ID(memId), 수정할 컬럼명(field), 수정할 데이터(data)
		 * @param paraMap 회원ID, 수정할 컬럼명, 수정할 데이터가 저장된 Map객체
		 * @return 작업 성공 : 1, 작업실패  : 0
		 */
		public int updateMember2(Map<String, String> paraMap);
}

