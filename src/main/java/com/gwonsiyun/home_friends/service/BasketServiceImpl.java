package com.gwonsiyun.home_friends.service;

import com.gwonsiyun.home_friends.dao.BasketDAO;
import com.gwonsiyun.home_friends.vo.BasketVO;
import com.gwonsiyun.home_friends.vo.MemberVO;
import com.gwonsiyun.home_friends.vo.PayInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BasketServiceImpl implements BasketService {

	@Autowired
	private BasketDAO basketDao;

	@Override
	public List<BasketVO> listPayFromBasket(BasketVO vo) throws Exception {
		
		List<BasketVO> list = basketDao.listPayFromBasket(vo);
		
		return list;
	}

	@Override
	public List<BasketVO> listBasket(MemberVO vo) throws Exception {
		
		List<BasketVO> list = basketDao.listBasket(vo);
		
		return list;
	}

	@Override
	public int deleteOneBasket(BasketVO vo) throws Exception {
		
		int result = basketDao.deleteOneBasket(vo);
		
		return result;
	}

	@Override
	public int plusCntBasket(BasketVO vo) throws Exception {
		
		int result = basketDao.plusCntBasket(vo);
		
		return result;
	}

	@Override
	public int minusCntBasket(BasketVO vo) throws Exception {

		int result = basketDao.minusCntBasket(vo);
		
		return result;
	}

	@Override
	public List<BasketVO> CheckedListBasket(BasketVO vo) throws Exception {
		
		List<BasketVO> list = basketDao.CheckedListBasket(vo);
		
		return list;
	}

	@Override
	public int deleteListBasket(BasketVO vo) throws Exception {

		int result = basketDao.deleteListBasket(vo);
		
		return result;
	}
	
	@Override
	public int insertOrderList(BasketVO vo) throws Exception {

		int result = basketDao.insertOrderList(vo);
		
		return result;
	}

	@Override
	public BasketVO directPayFromProduct(BasketVO vo) throws Exception {
		
		BasketVO basketvo = basketDao.directPayFromProduct(vo);
		
		return basketvo;
	}

	@Override
	public int insertPaymentInfo(PayInfoVO vo) throws Exception {

		int result = basketDao.insertPaymentInfo(vo);
		
		return result;
	}

	@Override
	public PayInfoVO payConfirm(PayInfoVO vo) throws Exception {

		PayInfoVO payInfovo = basketDao.payConfirm(vo);
		
		return payInfovo;
	}
	
	

}
