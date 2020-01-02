package com.aht.aht_crud.dao.impl;

import com.aht.aht_crud.dao.UserDAO;
import com.aht.aht_crud.dao.mapper.UserResultsetExtractor;
import com.aht.aht_crud.dao.mapper.UserRowMapper;
import com.aht.aht_crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("UserRepositoryImpl")
public class UserImpl implements UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(User user) {
        String query = "Insert into user value(?,?,?,?,?,?,?)";
        jdbcTemplate.update(query,user.getId(),user.getUserName(),user.getPassword(),user.getName(),user.getAge(),user.getGender(),user.getCity());
    }

    @Override
    public List<User> findAll() {
        String query = "Select * from user";
        return jdbcTemplate.query(query, new UserResultsetExtractor());
    }

    @Override
    public void update(User user) {
        String query = "UPDATE user SET user_name=?, password=?, name=?, age=?, gender=?, city=? WHERE id=?";
        jdbcTemplate.update(query,user.getUserName(),user.getPassword(),user.getName(),user.getAge(),user.getGender(),user.getCity(),user.getId());
    }

    @Override
    public void delete(int id) {
        String query = "Delete from user Where id=?";
        jdbcTemplate.update(query,id);
    }

    @Override
    public User findById(int id) {
        String query = "Select * from user where id = ?";
        return jdbcTemplate.queryForObject(query,new Object[] {id},new UserRowMapper());

    }
}
