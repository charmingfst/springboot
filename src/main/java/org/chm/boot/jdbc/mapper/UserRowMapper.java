package org.chm.boot.jdbc.mapper;

import org.chm.boot.jdbc.entity.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by charming on 2017/7/3.
 */
@Component
public class UserRowMapper implements RowMapper {

    public Object mapRow(ResultSet rs, int value) throws SQLException {
        User user = new User();
        user.setId(new Integer(rs.getInt("id")));
        user.setName(rs.getString("name"));
        user.setPwd(rs.getString("pwd"));
        return user;
    }
}
