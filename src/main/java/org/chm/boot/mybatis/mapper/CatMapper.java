package org.chm.boot.mybatis.mapper;

import org.apache.ibatis.annotations.*;
import org.chm.boot.mybatis.entity.Cat;

import java.util.List;

/**
 * Created by charming on 2017/7/4.
 */
public interface CatMapper {
    @Select("SELECT * FROM cat")
    @Results({
            @Result(property = "catName",  column = "cat_name", javaType = String.class),
            @Result(property = "catAge", column = "cat_age", javaType = Integer.class)
    })
    List<Cat> getAll();

    @Select("SELECT * FROM cat WHERE id = #{id}")
    @Results({
            @Result(property = "catName",  column = "cat_name", javaType = String.class),
            @Result(property = "catAge", column = "cat_age", javaType = Integer.class)
    })
    Cat getOne(Long id);

    @Insert("INSERT INTO cat(cat_name,cat_age) VALUES(#{catName}, #{catAge})")
    void insert(Cat user);

    @Delete("DELETE FROM cat WHERE id =#{id}")
    void delete(Long id);

    @Update("UPDATE cat SET cat_name=#{catName},cat_age=#{catAge} WHERE id =#{id}")
    int update(Cat cat);
}
