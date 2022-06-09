package com.gwonsiyun.home_friends.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginSuccessHandler implements AuthenticationSuccessHandler {
//    @Autowired // 타입으로 의존을 주입하는 어노테이션
//    private MemberService memberService;
//
//    @Autowired
//    private SqlSession sqlSession;
//
//    private static final String Namespace = "edu.study.mapper.memberMapper";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

//        HttpSession session = request.getSession();
////        MemberDAO memberService = new MemberDAO();//DAO바로 연결해보기
////        MemberServiceImpl memberService = new MemberServiceImpl();//Service바로연결해보기
//        String id = authentication.getName();
//        try {
//            MemberVO loginUser = memberService.loginUser(id);
////            MemberVO loginUser = sqlSession.selectOne(Namespace+".loginUser",id);//sqlsession으로 mapper바로 조회해보기
//            session.setAttribute("loginUser", loginUser);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        response.sendRedirect("/");

    }
}
