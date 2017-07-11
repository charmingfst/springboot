package org.chm.boot.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by charming on 2017/7/5.
 * 消息发送方
 */
@Component
public class HelloSender {

    protected static Logger logger= LoggerFactory.getLogger(HelloSender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public String send(String name) {
        String context = "hello "+name+" --" + new Date();
        logger.debug("HelloSender: " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
        return context;
    }
}