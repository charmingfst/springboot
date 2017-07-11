package org.chm.boot.cache;

import org.chm.boot.cache.entity.Employee;
import org.chm.boot.hello.SampleController;
import org.chm.boot.jdbc.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by charming on 2017/7/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleController.class)
public class CacheTest {
    @Autowired
    private EmployeeRepository userRepository;

    //    @Before
//    public void before() {
//        userRepository.save(new Employee("AAA", 10));
//    }
    @Autowired
    private CacheManager cacheManager;

    @Test
    public void test() throws Exception {
        System.out.println("classname;"+cacheManager.getClass().getSimpleName());
        Employee u1 = userRepository.findByName("AAA");
        System.out.println("第一次查询：" + u1.getAge());

        //使用缓存后，在调用第二次findByName函数时，没有再执行select语句
        Employee u2 = userRepository.findByName("AAA");
        System.out.println("第二次查询：" + u2.getAge());
    }
}
