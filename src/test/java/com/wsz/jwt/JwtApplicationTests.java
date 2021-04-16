package com.wsz.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

@Slf4j
@SpringBootTest
class JwtApplicationTests {

    @Test
    void contextLoads() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 200);

        HashMap<String,Object> map = new HashMap<>();
        String token = JWT.create()
//                .withHeader(map) //header
                .withClaim("userId", "21")
                .withClaim("userName", "wsz") //payload
                .withExpiresAt(calendar.getTime())  //指定令牌的过期时间
                .sign(Algorithm.HMAC256("!AHDHAHA1AJDASK"));
        log.error(token);
    }

    @Test
    public void test(){
        //创建验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("!AHDHAHA1AJDASK")).build();
        DecodedJWT verify = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MTg1NDc2NzMsInVzZXJJZCI6MjEsInVzZXJuYW1lIjoieGlhb2NoZW4ifQ.pJLnFPPZ2YLkB1H8ynlNZGwhHPqSwiNbI0_ZEotamdw");
        System.out.println(verify.getClaim("userId").asString()); //获取payload值
        System.out.println(verify.getClaim("userName").asString());
        Date expiresAt = verify.getExpiresAt(); //获取过期时间
        System.out.println(expiresAt);
    }
}
