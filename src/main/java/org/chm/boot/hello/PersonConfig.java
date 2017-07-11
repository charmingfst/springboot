package org.chm.boot.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by charming on 2017/6/30.
 */
@Configuration
@Import(TeacherConfig.class)  //导入TeacherConfig的配置
public class PersonConfig {

    @Bean
    public Person getPerson(Teacher teacher) //这里注入的这个bean是TeacherConfig.class中的Teacher类型的那个bean
    {
        Person person = new Person();
        person.setTeacher(teacher);
        return person;
    }


}
