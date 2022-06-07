package com.gwonsiyun.home_friends.config;

import com.gwonsiyun.home_friends.controller.CustomAuthenticationProvider;
import com.gwonsiyun.home_friends.service.LoginIdPwValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    LoginIdPwValidator loginIdPwValidator;

    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                    .antMatchers("/","/login/**","/store/**").permitAll()//로그인 예외 페이지설정

//    				.anyRequest().permitAll()//그 외의 페이지는 인증 불필요(배포 전 test용)
                    .anyRequest().authenticated()//그 외의 페이지는 인증이 필요함
                .and()
                    .csrf().disable()
                    .formLogin()
                    .loginPage("/login/login.do")
                    .loginProcessingUrl("/loginProc")
                    .usernameParameter("id")
                    .passwordParameter("pwd")
                    .defaultSuccessUrl("/", true)
                    .permitAll()
                .and()
                    .logout();
//                .and()
//                    .exceptionHandling()
//                    .accessDeniedPage("/login/login.do");
    }

    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/resources/**");
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider(authenticationProvider());
//                .userDetailsService(loginIdPwValidator);
    }
}
