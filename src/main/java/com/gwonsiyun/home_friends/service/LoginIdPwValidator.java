package com.gwonsiyun.home_friends.service;

import com.gwonsiyun.home_friends.util.SHA512PasswordEncoder;
import com.gwonsiyun.home_friends.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoginIdPwValidator implements UserDetailsService {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new SHA512PasswordEncoder();
    }

    @Autowired
    private MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String insertedId) throws UsernameNotFoundException {
        MemberVO user = new MemberVO();

        try {
            user = memberService.getUserInfo(insertedId);
        }catch (Exception e){
            e.printStackTrace();
        }

        if (user == null) {
            return null;
        }

        String pw = user.getPass();
        String roles = user.getGrade();

        return User.builder()
                .username(insertedId)
                .password(pw)
                .roles(roles)
                .build();
    }
}
