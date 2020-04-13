package com.txs.resume.resumeuser.service;

import com.txs.resume.resumeuser.pojo.TblCsmUser;

import java.util.HashMap;

public interface UserService {

    String sendEmail(String email);

    String register(HashMap<String,String> regCode, String email, String name, String code,String password);

    String login(String email,String password);
}
