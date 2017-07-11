package org.chm.boot.mq;

import org.chm.boot.mq.fanout.FanoutSender;
import org.chm.boot.mq.work.WorkSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by charming on 2017/7/5.
 */
@RestController("rabbitController")
public class HelloController {
    protected static Logger logger= LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloSender helloSender;

    @Autowired
    private WorkSender workSender;

    @RequestMapping("/send/{name}")
    public String helloworld(@PathVariable String name) {
        return helloSender.send(name);
    }

    @RequestMapping("/work/{name}")
    public String testwork(@PathVariable String name) {
        return workSender.send(name);
    }

    @Autowired
    private FanoutSender fanoutSender;

    @RequestMapping("/fanout")
    public String send() {
        fanoutSender.send();
        return "send ok";
    }
}