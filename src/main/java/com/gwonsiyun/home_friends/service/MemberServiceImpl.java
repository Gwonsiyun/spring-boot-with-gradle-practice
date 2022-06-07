package com.gwonsiyun.home_friends.service;

import com.gwonsiyun.home_friends.dao.MemberDAO;
import com.gwonsiyun.home_friends.vo.FollowVO;
import com.gwonsiyun.home_friends.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	@Override
	public int insert(MemberVO vo) throws Exception {
		return memberDao.insert(vo);
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return memberDao.login(vo);
	}

	@Override
	public MemberVO findId(MemberVO vo) throws Exception {
		return memberDao.findId(vo);
	}

	@Override
	public MemberVO findPwd(MemberVO vo) throws Exception {
		return memberDao.findPwd(vo);
	}

	@Override
	public int updateTempPwd(MemberVO vo) throws Exception {
		return memberDao.updateTempPwd(vo);
	}

	@Override
	public int insertTempNum(MemberVO vo) throws Exception {
		return memberDao.insertTempNum(vo);
	}

	@Override
	public int deleteTempNum(String id) throws Exception {
		return memberDao.deleteTempNum(id);
	}

	@Override
	public MemberVO idCheckMember(String id) throws Exception {
		return memberDao.idCheckMember(id);
	}

	@Override
	public MemberVO tempNumCheck(MemberVO vo) throws Exception {
		return memberDao.tempNumCheck(vo);
	}

	@Override
	public MemberVO refreshMember(MemberVO vo) throws Exception {
		return memberDao.refreshMember(vo);
	}
	
	//회원번호로 정보 가져오기
	@Override
	public MemberVO inquiryOfUserByMidx(int midx) throws Exception {
		
		return memberDao.inquiryOfUserByMidx(midx);
	}
	
	//회원 리스트 가져오기
	@Override
	public List<MemberVO> mlist() throws Exception {
		
		return memberDao.mlist();
	}

	@Override
	public List<MemberVO> notfollowlist(List<FollowVO> flist) throws Exception {
		
		return memberDao.notfollowlist(flist);
	}

	@Override
	public MemberVO loginNaverMember(MemberVO vo) throws Exception {
		
		return memberDao.loginNaverMember(vo);
	}

	@Override
	public int insertNaverMember(MemberVO vo) throws Exception {
		
		return memberDao.insertNaverMember(vo);
	}

	@Override
	public MemberVO phoneCheckMember(MemberVO vo) throws Exception {
		
		return memberDao.phoneCheckMember(vo);
	}

	@Override
	public MemberVO getUserInfo(String id) throws Exception {
		return memberDao.getUserInfo(id);
	}


}
