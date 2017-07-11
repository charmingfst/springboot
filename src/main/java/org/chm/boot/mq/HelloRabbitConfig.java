package org.chm.boot.mq;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by charming on 2017/7/5.
 */
@Configuration
public class HelloRabbitConfig {
    private final String EXCHANGE="spring-boot-exchange";

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue workQueue() {
        return new Queue("work-queue", true); //队列持久;
    }

    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(EXCHANGE);
    }
}