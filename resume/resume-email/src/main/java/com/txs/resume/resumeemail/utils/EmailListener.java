package com.txs.resume.resumeemail.utils;

import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;

@Component
@RabbitListener(queues = "email")
public class EmailListener {

    @Autowired
    JavaMailSender javaMailSender;

    @RabbitHandler
    public void sendEmail(HashMap<String, String> map) {
        System.out.println("发送验证码");
        String email = map.get("email");
        String code = map.get("code");
        SimpleMailMessage msg=new SimpleMailMessage();
        msg.setSubject("注册松松松简历系统验证码");
        msg.setFrom("t943044085@163.com");
        msg.setTo(email);
        msg.setText("您的验证码为:"+code);
        msg.setSentDate(new Date());
        javaMailSender.send(msg);
    }


}
