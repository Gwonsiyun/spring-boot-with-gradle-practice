package com.gwonsiyun.home_friends.controller;

import com.gwonsiyun.home_friends.service.MemberService;
import com.gwonsiyun.home_friends.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired // 타입으로 의존을 주입하는 어노테이션
    private MemberService memberService;

    private static final String Namespace = "edu.study.mapper.memberMapper";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        HttpSession session = request.getSession();
        String id = authentication.getName();
        try {
            MemberVO loginUser = memberService.loginUser(id);

            session.setAttribute("loginUser", loginUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("/");

    }
}
