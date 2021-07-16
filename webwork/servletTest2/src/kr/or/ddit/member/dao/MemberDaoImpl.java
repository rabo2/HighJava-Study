package kr.or.ddit.member.dao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import kr.or.ddit.member.vo.MemberVO;


public class MemberDaoImpl implements IMemberDao{
	// 1번
	private static MemberDaoImpl dao;
	private SqlMapClient smc;  // iBatis객체가 저장될 변수 선언
	
	// 2번
	private MemberDaoImpl() {
		try {
			// Dao의 생성자에서 iBatis 환경 설정 및 iBatis용 객체를 생성하는 일을 한다. 
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset);
			
			Reader rd = 
				Resources.getResourceAsReader("kr/or/ddit/config/sqlMapConfig.xml");
			smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// 3번
	public static MemberDaoImpl getInstance() {
		if(dao==null) dao = new MemberDaoImpl();
		
		return dao;
	}
	

	@Override
	public int insertMember(MemberVO memVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("member.insertMember", memVo);
			if(obj==null) cnt = 1;
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {
		int cnt = 0;
		try {
			cnt = smc.delete("member.deleteMember", memId);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVO memVo) {
		int cnt = 0;
		
		try {
			cnt = smc.update("member.updateMember", memVo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		
		return cnt;
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		List<MemberVO> memList = new ArrayList<>();
		
		try {
			memList = smc.queryForList("member.getAllMember");
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		} 
		
		return memList;
	}

	@Override
	public int getMemberCount(String memId) {
		int count = 0;  // 회원ID개수가 저장될 변수
		
		try {
			count = (int) smc.queryForObject("member.getMemberCount", memId);
		} catch (SQLException e) {
			count = 0;
			e.printStackTrace();
		} 
		
		return count;
	}

	@Override
	public int memberUpdate2(Map<String, String> paramMap) {
		// Key값 정보 ==> 회원ID(memId), 수정할컬럼명(field), 수정할데이터(data)
		int cnt = 0;
		try {
			cnt = smc.update("member.memberUpdate2", paramMap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public MemberVO detailMember(String mem_Id) {
		MemberVO vo = null;
		try {
			vo = (MemberVO) smc.queryForObject("member.detailMember",mem_Id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	
}
