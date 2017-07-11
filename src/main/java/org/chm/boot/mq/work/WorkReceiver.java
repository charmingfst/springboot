package org.chm.boot.mq.work;

import org.chm.boot.mq.HelloReceiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by charming on 2017/7/5.
 */
@Component
@RabbitListener(queues = "work-queue")
public class WorkReceiver {
    protected static Logger logger = LoggerFactory.getLogger(HelloReceiver.class);

    @RabbitHandler
    public void process(String hello) {
        logger.debug("workReceiver : " + hello);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
