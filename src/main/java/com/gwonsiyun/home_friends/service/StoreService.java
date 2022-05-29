package com.gwonsiyun.home_friends.service;

import com.gwonsiyun.home_friends.vo.SearchVO;
import com.gwonsiyun.home_friends.vo.StoreVO;
import com.gwonsiyun.home_friends.vo.SearchVO;
import com.gwonsiyun.home_friends.vo.StoreVO;

import java.util.List;

public interface StoreService {
	List<StoreVO> list(SearchVO vo) throws Exception;

}
