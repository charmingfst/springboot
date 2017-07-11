package org.chm.boot.tx;

import org.chm.boot.hello.SampleController;
import org.chm.boot.tx.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * Created by charming on 2017/7/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleController.class)
public class UserTransactionTest {
    @Autowired
    private AdminRepository userRepository;

    @Test
    @Transactional
    public void test() throws Exception {

        // 创建10条记录
        userRepository.save(new Admin("AAA", 10));
        userRepository.save(new Admin("BBB", 20));
        userRepository.save(new Admin("CCC", 30));
        userRepository.save(new Admin("DDD", 40));
        userRepository.save(new Admin("EEE", 50));
        userRepository.save(new Admin("FFFFFF", 60));
        userRepository.save(new Admin("GGG", 70));
        userRepository.save(new Admin("HHH", 80));
        userRepository.save(new Admin("III", 90));
        userRepository.save(new Admin("JJJ", 100));

        // 省略后续的一些验证操作
    }
}
