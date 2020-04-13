package com.txs.resume.resumeuser.config;


import com.txs.resume.resumeuser.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    //这个方法用来配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //表示所有路径请求都会被这个拦截器拦截
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
    }
}