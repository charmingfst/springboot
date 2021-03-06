package org.chm.boot.mq.fanout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by charming on 2017/7/5.
 */
@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {

    protected static Logger logger= LoggerFactory.getLogger(FanoutReceiverA.class);

    @RabbitHandler
    public void process(String message) {
        logger.debug("fanout Receiver A  : " + message);
    }

}
