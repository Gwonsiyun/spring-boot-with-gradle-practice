package com.gwonsiyun.home_friends.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                    .antMatchers("/","/login/**","/store/**").permitAll()//로그인 예외 페이지설정

    				.anyRequest().permitAll()//그 외의 페이지는 인증 불필요(배포 전 test용)
//                    .anyRequest().authenticated()//그 외의 페이지는 인증이 필요함
                .and()
                    .formLogin()
                    .loginPage("/login/login.do")
                    .defaultSuccessUrl("/", true)
                    .permitAll()
                .and()
                    .logout();
    }

    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/resources/**");
    }
}
