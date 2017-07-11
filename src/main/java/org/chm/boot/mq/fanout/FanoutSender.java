package org.chm.boot.mq.fanout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by charming on 2017/7/5.
 */
@Component
public class FanoutSender {

    protected static Logger logger= LoggerFactory.getLogger(FanoutSender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hi, fanout msg";
        logger.debug("Sender : " + context);
        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
    }

}
