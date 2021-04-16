package com.wsz.jwt.config;

import com.wsz.jwt.interceptor.JWTInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author by 完善者
 * @date 2021/4/16 15:27
 * @DESC
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptor())
                .addPathPatterns("/user/test")  //其他接口token验证
                .excludePathPatterns("/user/login"); //所有用户都放行
    }
}
