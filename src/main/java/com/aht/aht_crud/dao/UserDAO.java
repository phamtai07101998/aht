package com.aht.aht_crud.dao;

import com.aht.aht_crud.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    void insert(User user);

    List<User> findAll();

    void update(User user);

    void delete(int id);

    User findById(int id);

}
