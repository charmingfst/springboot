package org.chm.boot.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import java.util.Date;

/**
 * Created by charming on 2017/7/1.
 */
@Controller
public class HelloController {

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @Value("${custom.property.message}")
    private String customProperty;

    @RequestMapping("/custom")
    @ResponseBody
    public String test() {
        System.out.println("customProperty"+customProperty);
        return customProperty;
    }

//    @Autowired
//    ServletContext servletContext;

    @RequestMapping("/hello")
    public String welcome(ModelMap model) {
        model.put("time", new Date());
        model.put("message", this.message);
        System.out.println("hello===");
        return "hello";
    }

    @RequestMapping("/test")
    public String testJsp(ModelMap model) {
        model.put("time", new Date());
        model.put("message", this.message);
        System.out.println("hello===");
        return "test";
    }

    //spring boot 使用jackson
    @RequestMapping("/json")
    @ResponseBody
    public Person getPerson()
    {
        Teacher teacher = new Teacher();
        teacher.setName("张三");
        teacher.setAge(42);
        teacher.setCourse("English");
        Person person = new Person();
        person.setTeacher(teacher);
        return person;
    }

}
