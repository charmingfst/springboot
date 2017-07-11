package org.chm.boot.jpa;

import org.chm.boot.jpa.entity.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by charming on 2017/7/3.
 */
public interface CatRepository extends CrudRepository<Cat, Integer> {

}
