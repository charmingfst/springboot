package org.chm.boot.mybatis;

import org.chm.boot.hello.SampleController;
import org.chm.boot.mybatis.entity.Cat;
import org.chm.boot.mybatis.mapper.CatMapper;
import org.chm.boot.mybatis.mapper2.CatMapper2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by charming on 2017/7/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleController.class)
public class CatMapperTest {
    @Autowired
    private CatMapper2 catMapper;

    @Test
    public void testInsert() throws Exception {
        catMapper.insert(new Cat("dd", 2));
        catMapper.insert(new Cat("ee", 3));

//        Assert.assertEquals(3, catMapper.getAll().size());
    }

    @Test
    public void testQuery() throws Exception {
        List<Cat> cats = catMapper.getAll();
//        System.out.println(cats.toString());
        cats.forEach((o)-> System.out.println(o.getCatName()));

//        Cat cat = catMapper.getOne(1);
//        System.out.println("name::"+cat.getCatName());

    }

    @Test
    public void testUpdate() throws Exception {
        Cat cat = new Cat(1);
        cat.setCatAge(10);
        cat.setCatName("caiwang");
        int num = catMapper.update(cat);
        System.out.println("num::"+num);
        Assert.assertEquals(1, num);
    }

    @Test
    public void testDelete() throws Exception {
        int num = catMapper.delete(2);
        Assert.assertEquals(1, num);
    }
}
