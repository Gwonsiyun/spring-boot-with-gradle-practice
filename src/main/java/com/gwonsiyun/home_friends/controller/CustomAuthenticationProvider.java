package com.gwonsiyun.home_friends.controller;

import com.gwonsiyun.home_friends.service.MemberService;
import com.gwonsiyun.home_friends.vo.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private SqlSession sqlSession;
    @Autowired
    private MemberService memberService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String USER_ID = authentication.getName();
        String password = authentication.getCredentials().toString();



        MemberVO userDetails = new MemberVO();
        userDetails.setId(USER_ID);
        userDetails.setPass(password);


//        //암호화 시도 실패
//        SHA256 sha256 = new SHA256();
//        try {
//            password = sha256.encrypt(password);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        try {
            userDetails = memberService.login(userDetails);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(userDetails==null) {
            throw new BadCredentialsException("아이디와 비밀번호를 확인해주세요");
        }

//        if(!userDetails.isEnabled()) {
//            throw new BadCredentialsException("비활성화된 아이디 입니다.");
//        }
//        List<Map<String, Object>> userRoles = sqlSession.selectList("getUserRole", USER_ID);
        ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

//        //todo 임시 비활성화 시작
//        try {
//            if (userRoles.size() > 0) {
//                userRoles.forEach(role -> {
//                    if(role.get("ROLE_IDX") != null)
//                        authorities.add(new SimpleGrantedAuthority(role.get("ROLE_IDX").toString()));
//                });
//                userDetails.setAuthorities(authorities);
//            }
//        }catch (Exception e){
//            throw new BadCredentialsException("권한이 존재하지 않습니다.");
//        }
//        //todo 임시 비활성화 종료




        //todo 임시 설정 시작
//		authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
//		authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        //todo 임시 설정 종료

        UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(userDetails, null, authorities);
        result.setDetails(authentication.getDetails());
        return result;

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
