package com.gwonsiyun.home_friends.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gwonsiyun.home_friends.dao.StoreDAO;
import com.gwonsiyun.home_friends.vo.StoreVO;
import com.gwonsiyun.home_friends.vo.SearchVO;


@Service("StoreService")
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreDAO StoreDao;
	
	@Override
	public List<StoreVO> list(SearchVO vo) throws Exception {
		
		List<StoreVO> list = StoreDao.list(vo);
		
		return list;
	}



}
