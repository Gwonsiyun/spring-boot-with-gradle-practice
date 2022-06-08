package com.gwonsiyun.home_friends.service;

import com.gwonsiyun.home_friends.vo.FollowVO;
import com.gwonsiyun.home_friends.vo.MemberVO;

import java.util.List;

public interface MemberService {
	
	int insert(MemberVO vo) throws Exception;
	MemberVO login(MemberVO vo) throws Exception;
	MemberVO findId(MemberVO vo) throws Exception;
	MemberVO findPwd(MemberVO vo) throws Exception;
	int updateTempPwd(MemberVO vo) throws Exception;
	int insertTempNum(MemberVO vo) throws Exception;
	int deleteTempNum(String id) throws Exception;
	MemberVO idCheckMember(String id) throws Exception;
	MemberVO tempNumCheck(MemberVO vo) throws Exception;
	MemberVO refreshMember(MemberVO vo) throws Exception;
	MemberVO inquiryOfUserByMidx(int midx) throws Exception;
	List<MemberVO> mlist() throws Exception;
	List<MemberVO> notfollowlist(List<FollowVO> flist) throws Exception;
	MemberVO loginNaverMember(MemberVO vo) throws Exception;
	int insertNaverMember(MemberVO vo) throws Exception;
	MemberVO phoneCheckMember(MemberVO vo) throws Exception;

	MemberVO getUserInfo(String id) throws Exception;

	MemberVO loginUser(String id) throws Exception;

}
