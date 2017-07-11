package org.chm.boot.hello;

import io.swagger.annotations.SwaggerDefinition;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by charming on 2017/6/30.
 */
//@Controller
@RestController
@ComponentScan("org.chm.boot")
@EnableAutoConfiguration
@EnableJpaRepositories({"org.chm.boot.jpa","org.chm.boot.tx", "org.chm.boot.cache"})
@EntityScan({"org.chm.boot.jpa.entity","org.chm.boot.tx.entity", "org.chm.boot.cache.entity"}) //数据库里自动生成对应实体的表结构
@MapperScan({"org.chm.boot.mybatis.mapper","org.chm.boot.mybatis.mapper2"})
//@SpringBootApplication
@SwaggerDefinition
@EnableCaching
@RequestMapping("/test")
@ServletComponentScan(basePackages = {"org.chm.boot.servlet"})
public class SampleController {

    @Value("${chm.secret}")
    private String secret;


//    @Bean(name = "people")
//    public People getPeople(){
//        People people = new People();
//        people.setName("zhangsan");
//        people.setAge(20);
//        return people;
//    }
//
    @Autowired
    private People people;

    @RequestMapping("/wo")
//    @ResponseBody
    String home()
    {
        return "Hello World! " +people.getName();
    }

    @RequestMapping("/hi/{name}")
//    @ResponseBody
    public String helloName(@PathVariable String name){
        return "Hello "+name;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
