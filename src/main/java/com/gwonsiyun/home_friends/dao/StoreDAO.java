package com.gwonsiyun.home_friends.dao;


import com.gwonsiyun.home_friends.vo.SearchVO;
import com.gwonsiyun.home_friends.vo.StoreVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("storeDAO") // 컴포넌트 하위에 있는 어노테이션, 외부와 연결 할 때 사용하는 어노테이션
public class StoreDAO {

	@Autowired // 타입으로 의존을 주입하는 어노테이션
	private SqlSession sqlSession;

	private static final String Namespace = "edu.study.mapper.storeMapper";

	public List<StoreVO> list(SearchVO vo) throws Exception {
		return sqlSession.selectList("storeMapper.listStore",vo);
	}

}








