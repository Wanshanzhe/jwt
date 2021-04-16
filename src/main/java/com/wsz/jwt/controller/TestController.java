package com.wsz.jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author by 完善者
 * @date 2021/4/15 15:23
 * @DESC
 */
@RestController
public class TestController {

    @GetMapping("/test/test")
    public String login(String Username, HttpServletRequest request){
        // 认证成功放入session
        request.getSession().setAttribute("Username", Username);
        return "login ok~";
    }

    @GetMapping("/test/test1")
    public String test1(String username,HttpServletRequest request){
        // 认证成功放入session
        request.getSession().getAttribute("username");
        return "login ok~";
    }

}
