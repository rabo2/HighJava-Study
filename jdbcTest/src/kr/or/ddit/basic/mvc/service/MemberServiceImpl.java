package kr.or.ddit.mvc.service;

import java.util.List;

import kr.or.ddit.mvc.dao.IMemeberDAO;
import kr.or.ddit.mvc.dao.MemberDAOImpl;
import kr.or.ddit.mvc.vo.MemberVO;

public class MemberServiceImpl implements IMemberService{
	private IMemeberDAO memDao;
	
	public void MeberServiceImpl() {
		memDao = new MemberDAOImpl();
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

}
