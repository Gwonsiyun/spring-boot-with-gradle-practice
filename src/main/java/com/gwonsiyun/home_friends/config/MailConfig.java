package com.gwonsiyun.home_friends.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.auth","true");
        props.put("mail.transport.protocol","smtp");
        props.put("mail.debug","true");
        props.put("mail.smtp.ssl.trust","smtp.gmail.com");
        props.put("mail.smtp.ssl.protocols","TLSv1.2");

        javaMailSender.setProtocol("smtp");
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("homefriendsmail");
        javaMailSender.setPassword("friends1234!!");
        javaMailSender.setJavaMailProperties(props);


        return javaMailSender;
    }

}
