package com.wsz.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @author by 完善者
 * @date 2021/4/16 12:39
 * @DESC
 */
public class JWTUtils {

    private static final String SIGN  = "!Q@W#E$R";

    /**
     * 生成token header.payload.sing
     */
    public static String getToken(Map<String,String> map){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 7); //默认七天过期
        //创建jwt builder
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        //sign
        String token = builder.withExpiresAt(calendar.getTime()) //指定令牌过期时间
                .sign(Algorithm.HMAC256(SIGN));
        return token;
    }

    /**
     * 验证token合法性
     * @param token
     */
    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
    }

    /**
     * 获取token中的信息
     * @param token
     * @return
     */
//    public static DecodedJWT getTokenInfo(String token){
//        DecodedJWT verify = JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
//        return verify;
//    }
}
