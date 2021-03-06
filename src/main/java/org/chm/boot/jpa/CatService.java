package org.chm.boot.jpa;

import org.chm.boot.jpa.entity.Cat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by charming on 2017/7/3.
 */
@Service
public class CatService {
    @Resource
    private CatRepository catRepository;
    /*
     * save,update,delete方法需要绑定事务。
     * 使用@Transactional进行事务绑定。
     */

    // 保存数据
    @Transactional
    public void save(Cat cat) {
        catRepository.save(cat);
    }

    // 删除数据
    @Transactional
    public void delete(int id) {
        catRepository.delete(id);
    }

    // 查询数据
    public Iterable<Cat> getAll() {
        return catRepository.findAll();
    }
}