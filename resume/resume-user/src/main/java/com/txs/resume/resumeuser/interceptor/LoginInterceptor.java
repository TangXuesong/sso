package com.txs.resume.resumeuser.interceptor;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
*
* 使用拦截器校验该用户是否登录
*
* */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private Logger logger= LogManager.getLogger(LoginInterceptor.class.getName());

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("进入到登录中心拦截器");
        Object user = request.getSession().getAttribute("user");
        //判断是否已经登录过,如果没有登录就放行去登录界面.
        logger.info(user);
        if(user==null){
            return true;
        }
        //登陆过就直接获取token并返回给简历中心
        String token = request.getSession().getId();
        logger.info(token);
        String redirect_url = request.getParameter("redirect_url");
        logger.info(redirect_url);
        response.sendRedirect(redirect_url+"?token="+token);
        return false;
    }
}
