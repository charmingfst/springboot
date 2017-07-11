package org.chm.boot.mq.work;

import org.chm.boot.mq.HelloSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by charming on 2017/7/5.
 */
@Component
public class WorkSender {

    protected static Logger logger= LoggerFactory.getLogger(HelloSender.class);

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public String send(String name) {
        String context = "hello "+name+" --" + new Date();
        String sendStr;
        for(int i=1;i<=100;i++){
            sendStr="第["+i+"]个 hello "+name+" --" + new Date();
            logger.debug("HelloSender: " + sendStr);
            this.rabbitTemplate.convertAndSend("work-queue", sendStr);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return context;
    }
}