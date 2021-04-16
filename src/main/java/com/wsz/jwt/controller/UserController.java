package com.wsz.jwt.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.wsz.jwt.dao.entity.Users;
import com.wsz.jwt.service.IUsersService;
import com.wsz.jwt.util.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by 完善者
 * @date 2021/4/16 14:47
 * @DESC
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private IUsersService iUsersService;

    @GetMapping("/user/login")
    public Map<String,Object> login(Users user){
        log.info("用户名：{}",user.getUsername());
        log.info("密码：{}",user.getPassword());
        Map<String, Object> map = new HashMap<>();
        try {
            Users userDB = iUsersService.login(user);
            Map<String,String> payload = new HashMap<>();
            payload.put("id", userDB.getId().toString());
            payload.put("name",userDB.getUsername());
            //生成jwt令牌
            String token = JWTUtils.getToken(payload);
            map.put("status", true);
            map.put("msg", "认证成功");
            map.put("token",token); //响应token
        } catch (Exception e) {
            map.put("msg", false);
            map.put("msg", e.getMessage());
        }
        return map;
    }

    @PostMapping("/user/test")
    public Map<String,Object> test(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        //处理自己的业务逻辑
        String token = request.getHeader("token");
        DecodedJWT verify = JWTUtils.verify(token);
        log.info("用户id:{},用户name:{}",verify.getClaim("id").asString(),verify.getClaim("name").asString());
        map.put("status","200");
        return map;
    }
}
