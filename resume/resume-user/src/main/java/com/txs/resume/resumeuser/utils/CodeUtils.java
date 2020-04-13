package com.txs.resume.resumeuser.utils;

import java.util.Random;

public class CodeUtils {

    public static String createCode() {

        String sources = "0123456789"; // 加上一些字母，就可以生成pc站的验证码了
        Random rand = new Random();
        StringBuffer code = new StringBuffer();
        for (int j = 0; j < 6; j++) {
            code.append(sources.charAt(rand.nextInt(9)) + "");
        }

        return code.toString();
    }

}
