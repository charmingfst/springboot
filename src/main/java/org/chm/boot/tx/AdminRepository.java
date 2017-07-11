package org.chm.boot.tx;

import org.chm.boot.tx.entity.Admin;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by charming on 2017/7/4.
 */
public interface AdminRepository extends CrudRepository<Admin, Long> {
}
