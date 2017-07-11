package org.chm.boot.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by charming on 2017/6/30.
 */
@Configuration
public class TeacherConfig {

    @Bean
    public Teacher getTeacher()
    {
        Teacher teacher = new Teacher();
        teacher.setName("lisi");
        teacher.setAge(30);
        teacher.setCourse("math");
        return teacher;
    }
}
