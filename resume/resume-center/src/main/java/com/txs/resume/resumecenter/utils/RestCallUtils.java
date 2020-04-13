package com.txs.resume.resumecenter.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Component
public class RestCallUtils {

    private static RestTemplate restTemplate;

    public static final String USERSERVICE="resume-user"; //登录中心服务
    public static final String USERSERVICE_CHECKLOGIN="/user/checkLogin"; //登录中心提供的校验用户登录接口名
    public static final String RESUMESERVICE="resume-center"; //简历中心服务

    public static Logger logger= LogManager.getLogger(RestCallUtils.class.getName());

    public static String callAndGet(String servicename, String interfacename, MultiValueMap<String,Object> map){
        String uri=String.format("http://%s"+interfacename, servicename);
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String, Object>>(map,new HttpHeaders());
        logger.info(uri);
        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, String.class);
        return responseEntity.getBody();
    }


    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}
