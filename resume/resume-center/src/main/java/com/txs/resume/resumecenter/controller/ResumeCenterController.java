package com.txs.resume.resumecenter.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("resume")
@Controller
public class ResumeCenterController {

    private Logger logger = LogManager.getLogger(ResumeCenterController.class.getName());

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        logger.info("进入到test方法");
        return "ok";
    }

}
