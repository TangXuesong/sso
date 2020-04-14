package com.txs.resume.resumeuser.rabbit;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.io.IOException;

public class RabbitConfirmCallback implements RabbitTemplate.ConfirmCallback {

    private Logger logger = LogManager.getLogger(RabbitConfirmCallback.class.getName());


    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        logger.info("(start)生产者消息确认=========================");
        logger.info("correlationData:[{}]", correlationData);
        logger.info("ack:[{}]", b);
        logger.info("cause:[{}]", s);
        if (!b) {
            logger.info("消息可能未到达rabbitmq服务器");
        }
        logger.info("(end)生产者消息确认=========================");
    }
}
