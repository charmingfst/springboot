package org.chm.boot.jdbc;

import org.chm.boot.jdbc.entity.User;
import org.chm.boot.jdbc.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static jdk.nashorn.internal.objects.NativeFunction.call;

/**
 * Created by charming on 2017/7/3.
 */
@Service
public class UserServiceImpl implements UserService {
    //Spring的JdbcTemplate是自动配置的，你可以直接使用@Autowired来注入到你自己的bean中来使用
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserRowMapper userRowMapper;

    @Override
    public void create(String name, String pwd) {
        jdbcTemplate.update("insert into USER(NAME, PWD) values(?, ?)", name, pwd);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from USER where NAME = ?", name);
    }

    @Override
    public Integer getAllUsers() {
        //3.查询一行任何类型的数据，最后一个参数指定返回结果类型
        return jdbcTemplate.queryForObject("select count(NAME) from USER", Integer.class);
    }

    @Override
    public User getUser(int id) {
//        User user = (User) jdbcTemplate.queryForObject("select * from USER WHERE id = ?", new Object[]{id}, userRowMapper);
        User user = (User) jdbcTemplate.queryForObject("select * from USER WHERE id = " + id, userRowMapper);

        return user;
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from USER");
    }

    /*
    CREATE DEFINER=`root`@`localhost` PROCEDURE `user_test`(
	IN `user_pwd` VARCHAR(50),
	OUT `count_num` INT

    )
    LANGUAGE SQL
    NOT DETERMINISTIC
    CONTAINS SQL
    SQL SECURITY DEFINER
    COMMENT ''
    BEGIN
        SELECT  COUNT(*)  INTO  count_num
       FROM  user
       WHERE pwd=user_pwd ;
    END

    call user_test('11', @num);
    select @num;
     */
    @Override
    public int getCall() {
        /*int param2Value = (int) jdbcTemplate.execute(
                new CallableStatementCreator() {
                    public CallableStatement createCallableStatement(Connection con) throws SQLException {
                        String storedProc = "{call user_test(?,?)}";// 调用的sql
                        CallableStatement cs = con.prepareCall(storedProc);
                        cs.setString(1, "11");// 设置输入参数的值
                        cs.registerOutParameter(2, Types.INTEGER);// 注册输出参数的类型
                        return cs;
                    }
                }, new CallableStatementCallback() {
                    public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
                        cs.execute();
                        return cs.getInt(2);// 获取输出参数的值
                    }
                });
        System.out.println("num::" + param2Value);
        return  param2Value;*/
        List<SqlParameter> params = new ArrayList<SqlParameter>();
        params.add(new SqlParameter("user_pwd", Types.VARCHAR));
        params.add(new SqlOutParameter("result", Types.INTEGER));
        Map<String, Object> values = jdbcTemplate.call(new CallableStatementCreator() {
            @Override
            public CallableStatement createCallableStatement(Connection con) throws SQLException {
                String storedProc = "{call user_test(?,?)}";// 调用的sql
                CallableStatement cs = con.prepareCall(storedProc);
                cs.setString(1, "11");// 设置输入参数的值
                cs.registerOutParameter(2, Types.INTEGER);// 注册输出参数的类型
                return cs;
            }
        }, params);
        System.out.println("num::" + values.get("result") + ";" + values.size());
        values.forEach((s, o) -> {
            System.out.println("value:" + s + ";" + o);
        });
        return (int) values.get("result");


    }
}
