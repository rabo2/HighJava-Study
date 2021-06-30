package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.dao.IMemeberDAO;
import kr.or.ddit.mvc.dao.MemberDAOImpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberServiceImpl implements IMemberService{
	private static MemberServiceImpl service;
	private IMemeberDAO memDao;

	
	private MemberServiceImpl() {
		this.memDao = MemberDAOImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance() {
		if(service == null) service = new MemberServiceImpl();
		return service;
	}
	
	@Override
	public int insertMember(MemberVO memberVO) {
		return memDao.insertMember(memberVO);
	}

	@Override
	public int deleteMember(String memId) {
		return memDao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memberVO) {
		return memDao.updateMember(memberVO);
	}

	@Override
	public List<MemberVO> getAllMemberList() {
		return memDao.getAllMemberList();
	}

	@Override
	public int getMeberCount(String memId) {
		return memDao.getMeberCount(memId);
	}

//	@Override
//	public int updateMember2(String dataType, String updateData, String memId) {
//		return memDao.updateMember2(dataType, updateData, memId);
//	}

	@Override
	public int updateMember2(Map<String, String> paraMap) {
		return memDao.updateMember2(paraMap);
	}

}
