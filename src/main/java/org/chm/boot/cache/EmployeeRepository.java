package org.chm.boot.cache;

import org.chm.boot.cache.entity.Employee;
import org.chm.boot.jdbc.entity.User;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by charming on 2017/7/5.
 */
@CacheConfig(cacheNames = "employee")
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    @Cacheable
    Employee findByName(String name);
}
