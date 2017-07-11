package org.chm.boot.jdbc;

import org.chm.boot.jdbc.entity.User;

/**
 * Created by charming on 2017/7/3.
 */
public interface UserService {
    /**
     * 新增一个用户
     * @param name
     * @param pwd
     */
    void create(String name, String pwd);
    /**
     * 根据name删除一个用户
     * @param name
     */
    void deleteByName(String name);
    /**
     * 获取用户总量
     */
    Integer getAllUsers();

    User getUser(int id);


    /**
     * 删除所有用户
     */
    void deleteAllUsers();

    int getCall();
}