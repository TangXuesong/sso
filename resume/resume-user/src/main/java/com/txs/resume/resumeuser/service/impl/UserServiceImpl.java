package com.txs.resume.resumeuser.service.impl;

import com.alibaba.fastjson.JSON;
import com.txs.resume.resumeuser.mapper.TblCsmUserMapper;
import com.txs.resume.resumeuser.pojo.TblCsmUser;
import com.txs.resume.resumeuser.service.UserService;
import com.txs.resume.resumeuser.utils.CodeUtils;
import com.txs.resume.resumeuser.utils.DateUtils;
import com.txs.resume.resumeuser.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TblCsmUserMapper tblCsmUserMapper;

    //发送注册邮件
    @Override
    public String sendEmail(String email) {
        //先校验邮箱格式是否正确
        if (!email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
            return "false";
        }
        //先查询数据库,校验该邮箱是否已经注册.
        TblCsmUser user = tblCsmUserMapper.selectByEmail(email);
        if(user!=null)
            return "false";
        //生成六位数作为验证码
        String code = CodeUtils.createCode();
        //此处调用rabiitMQ通知邮箱服务发送邮件给对应邮箱.
        return code;
    }

    //注册账号
    @Override
    public String register(HashMap<String, String> regCode, String email, String name, String code, String password) {
        //先校验验证码和邮箱是否正确
        String sendCode = regCode.get(email);
        if(!code.equals(sendCode))
            return "codeError";

        //正确的情况下查询数据库该邮箱是否已经注册过
        TblCsmUser dbUser = tblCsmUserMapper.selectByEmail(email);
        if(dbUser!=null)
            return "hasError";
        //没有注册过则添加该用户
        TblCsmUser user=new TblCsmUser();
        user.setUrAge(20); //默认20
        user.setUrEmail(email);//注册邮箱
        user.setUrNickname(name);//用户昵称
        user.setUrRegisterTime(DateUtils.getCurrDatetoHHmmss()); //当前系统时间戳
        user.setUrSex("0"); //默认是男
        user.setUrPassword(MD5Utils.inputPassToFormPass(password));
        tblCsmUserMapper.insertSelective(user);
        return "true";
    }

    //登录
    @Override
    public String login(String email, String password) {
        //1.从数据库中获取该邮箱对应的用户
        TblCsmUser dbUser = tblCsmUserMapper.selectByEmail(email);
        if(dbUser==null)
            return "false";
        if(!dbUser.getUrPassword().equals(MD5Utils.inputPassToFormPass(password)))
            return "false";
        return JSON.toJSONString(dbUser);
    }
}
