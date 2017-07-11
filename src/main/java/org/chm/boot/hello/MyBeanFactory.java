package org.chm.boot.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by charming on 2017/6/30.
 */
@Configuration
public class MyBeanFactory {
    @Bean(name = "people")
    public People getPeople(){
        People people = new People();
        people.setName("zhangsan");
        people.setAge(20);
        return people;
    }
}
