package org.chm.boot.mybatis.mapper2;

import org.chm.boot.mybatis.entity.Cat;

import java.util.List;

/**
 * Created by charming on 2017/7/4.
 */
public interface CatMapper2 {
    List<Cat> getAll();

    Cat getOne(Integer id);

    void insert(Cat user);

    int update(Cat user);

    int delete(Integer id);
}
