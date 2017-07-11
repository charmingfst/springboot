package org.chm.boot.jpa;

import org.chm.boot.jpa.entity.Course;
import org.hibernate.annotations.Parameter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by charming on 2017/7/3.
 */
//框架提供好的接口 Repository 或 CrudRepository （CrudRepository 继承自 Repository）

public interface IScoreDao extends JpaRepository<Course, Integer> {

    @Transactional
    @Modifying //使用 @Modifying 将查询标识为修改
    //使用 :id 这种方式标记参数，在参数列表中使用@Param来呼应 Course是不是course,Course指的是Coruse实体类
    @Query("update Course t set t.score = :score where t.id = :id")
    int updateScoreById(@Param("score") float score, @Param("id") int id);
    //JPQL语句
    @Query("select t from Course t ")
    List<Course> getList();

}