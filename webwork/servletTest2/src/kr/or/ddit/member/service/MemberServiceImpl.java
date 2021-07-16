package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;


public class MemberServiceImpl implements IMemberService {
	private IMemberDao memDao;
	
	private static MemberServiceImpl service;
	
	private MemberServiceImpl() {
		//memDao = new MemberDaoImpl();
		memDao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {
		if(service==null) service = new MemberServiceImpl();
		return service;
	}
	
	@Override
	public int insertMember(MemberVO memVo) {
		return memDao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String memId) {
		return memDao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memVo) {
		return memDao.updateMember(memVo);
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		return memDao.getAllMemberList();
	}

	@Override
	public int getMemberCount(String memId) {
		return memDao.getMemberCount(memId);
	}

	@Override
	public int memberUpdate2(Map<String, String> paramMap) {
		return memDao.memberUpdate2(paramMap);
		
	}

	@Override
	public MemberVO detailMember(String memId) {
		return memDao.detailMember(memId);
	}

}
