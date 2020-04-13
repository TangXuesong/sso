package com.txs.resume.resumecenter.interceptor;

import com.alibaba.fastjson.JSON;
import com.txs.resume.resumecenter.pojo.TblCsmUser;
import com.txs.resume.resumecenter.utils.RestCallUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

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
        logger.info("进入到简历中心拦截器");
        Object user = request.getSession().getAttribute("resUser");
        logger.info(user);
        //先检查是否有用户登录信息,有就让其通过.
        if(user!=null){
            return true;
        }
        //检查登录中心返回的token是否有效,
        String token=request.getParameter("token");
        if(token!=null){
            //用该token去redis数据库查询取到对应的用户信息,存放在session中表示局部变量
            String userJson = stringRedisTemplate.opsForValue().get("user" + token);
            TblCsmUser csmUser = JSON.parseObject(userJson,TblCsmUser.class);
            request.getSession().setAttribute("resUser",csmUser);
            return true;
        }
        //获取登录中心的登录地址跳转过去进行登录并带上返回地址
        ServiceInstance serviceInstance = loadBalancerClient.choose(RestCallUtils.USERSERVICE);
        String redirect_uri=request.getRequestURL().toString();
        logger.info(redirect_uri);
        response.sendRedirect("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/login.html?redirect_uri="+redirect_uri);
        return false;

    }
}
