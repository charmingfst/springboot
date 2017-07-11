package org.chm.boot.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by charming on 2017/7/5.
 */
@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {
    protected static Logger logger = LoggerFactory.getLogger(HelloReceiver.class);

    @RabbitHandler
    public void process(String hello) {
        logger.debug("HelloReceiver : " + hello);
    }
}
