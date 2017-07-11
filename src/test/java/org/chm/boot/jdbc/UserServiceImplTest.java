package org.chm.boot.jdbc;

import org.chm.boot.hello.SampleController;
import org.chm.boot.jdbc.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.servlet.ServletContext;

/**
 * Created by charming on 2017/7/3.
 */
//spring boot 1.5之后测试配置
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleController.class)
@WebAppConfiguration //由于是Web项目，Junit需要模拟ServletContext，需要给我们的测试类加上@WebAppConfiguration。
public class UserServiceImplTest {

    @Autowired
    ServletContext servletContext;

    @Autowired
    private UserService userSerivce;
//    @Before
//    public void setUp() {
//        // 准备，清空user表
//        userSerivce.deleteAllUsers();
//    }
    @Test
    public void test() throws Exception {
//        System.out.println("==="+servletContext.getServletContextName()+":"+servletContext.getServerInfo());
//        // 插入5个用户
//        userSerivce.create("a", "11");
//        userSerivce.create("b", "22");
//        userSerivce.create("c", "33");
//        // 查数据库，应该有5个用户
//        Assert.assertEquals(3, userSerivce.getAllUsers().intValue());
        User user = userSerivce.getUser(15);
        Assert.assertEquals("c",  user.getName());
//        // 删除两个用户
//        userSerivce.deleteByName("a");
//        userSerivce.deleteByName("e");
//        // 查数据库，应该有5个用户
//        Assert.assertEquals(3, userSerivce.getAllUsers().intValue());
    }

    @Test
    public void testCall() throws Exception {
        int num = userSerivce.getCall();
        Assert.assertEquals(2, num);
    }

}
