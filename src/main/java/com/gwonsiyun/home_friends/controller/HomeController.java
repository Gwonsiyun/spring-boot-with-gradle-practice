package com.gwonsiyun.home_friends.controller;

import com.gwonsiyun.home_friends.service.StoreService;
import com.gwonsiyun.home_friends.vo.SearchVO;
import com.gwonsiyun.home_friends.vo.StoreVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Resource(name="StoreService")
	private StoreService storeService;



	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, SearchVO vo, HttpServletRequest request) throws Exception {

	    SearchVO searchvo = new SearchVO();
	    searchvo.setReview_cnt("yes");
	    searchvo.setPage("limit");
	    List<StoreVO> storeList = storeService.list(searchvo);

	    model.addAttribute("storeList",storeList);

		return "home";
	}



}
