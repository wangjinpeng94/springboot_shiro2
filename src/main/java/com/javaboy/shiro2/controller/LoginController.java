package com.javaboy.shiro2.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/login")
    public String login(){
        return "please login";
    }
    @GetMapping("/doLogin")
    public void doLogin(String username,String password){
        Subject subject= SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username,password));
            System.out.println("success");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("fail>" + e.getMessage());
        }
    }


}
