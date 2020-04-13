package com.txs.resume.resumeuser.controller;

import com.txs.resume.resumeuser.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    private  Logger logger =  LogManager.getLogger(UserController.class.getName());

    @Autowired
    private StringRedisTemplate redisTemplate;

    //登录
    @RequestMapping("login")
    public String login(HttpServletResponse response, HttpSession session, String email, String password) {
        String result= userService.login(email, password);
        if(result.equals("false"))
            return "false";
        //写入redis数据库,将该token以及用户信息
        redisTemplate.opsForValue().set("user"+session.getId(),result,1800,TimeUnit.MINUTES);
        //写入session以示登录成功
        session.setAttribute("user",result);
        return session.getId();
    }

    //注册
    @RequestMapping("register")
    public String register(HttpSession session, String email, String code, String password, String name) {
        //先从session中取出regCodeMap
        HashMap<String, String> regCode = (HashMap<String, String>) session.getAttribute("regCode");
        if (regCode == null)
            return "codeError";
        return userService.register(regCode, email, name, code, password);

    }

    //发送验证码
    @RequestMapping("sendEmail")
    public String sendEmail(HttpSession session, String email) {
        String code = userService.sendEmail(email);
        if (code.equals("false")) {
            return "false";
        }
        HashMap<String, String> map = new HashMap<>();
        logger.info("email------:"+email+"---------code-------:"+code);
        map.put(email, code);
        session.setAttribute("regCode", map);
        return "true";
    }




}
