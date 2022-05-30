package com.gwonsiyun.home_friends.service;

import com.gwonsiyun.home_friends.vo.HomeSearchVO;

import java.util.List;

public interface HomeService {
	
//	List<HomeStoryVO> searchStory(HomeSearchVO vo) throws Exception;
//	List<HomeStoreVO> searchStore(HomeSearchVO vo) throws Exception;
	List<HomeSearchVO> listSearchList() throws Exception;
//	int insertSearchList(HomeSearchVO vo) throws Exception;
	int deleteSearchList() throws Exception;
//	HomeStoreVO recentViewStore(HomeStoreVO vo) throws Exception;
}
