package com.gwonsiyun.home_friends.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("/main")
public class Mainpage {

    @GetMapping(value="/home.do")
    public String home(HttpServletRequest seq, Locale locale, Model model) throws Exception{

        System.out.println("requested correctly");
        return "home";
    }

}
