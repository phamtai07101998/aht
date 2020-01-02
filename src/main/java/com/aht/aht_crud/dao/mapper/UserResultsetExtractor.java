package com.aht.aht_crud.dao.mapper;

import com.aht.aht_crud.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserResultsetExtractor implements ResultSetExtractor<List<User>> {
    @Override
    public List<User> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<User> users = new ArrayList<>();
        while (resultSet.next()){
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUserName(resultSet.getString("user_name"));
            user.setPassword(resultSet.getString("password"));
            user.setName(resultSet.getString("name"));
            user.setGender(resultSet.getString("gender"));
            user.setAge(resultSet.getInt("age"));
            user.setCity(resultSet.getString("city"));
            users.add(user);
        }
        return users;
    }
}
