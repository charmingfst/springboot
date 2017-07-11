package org.chm.boot.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by charming on 2017/6/30.
 */
@Controller
public class TestController {

    @Autowired
    private Person person;
//
//    @RequestMapping("/")
//    @ResponseBody
//    String home()
//    {
//        System.out.println("aaa---");
//        return "Hello World! " +people.getName();
//    }
    @RequestMapping("/person")
    @ResponseBody
    String home()
    {
        System.out.println("aaa---");
        return "Hello World! " +person.getTeacher().getCourse();
    }

    @RequestMapping("/people")
    @ResponseBody
    String pepple()
    {
        System.out.println("bbb---");
        People people = (People) SpringUtil.getBean("people");
        return "Hello World! " + people.getName();
    }
}
