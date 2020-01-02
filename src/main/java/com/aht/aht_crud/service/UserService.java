package com.aht.aht_crud.service;

import com.aht.aht_crud.dao.UserDAO;
import com.aht.aht_crud.dto.UserDTO;
import com.aht.aht_crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    @Qualifier("UserRepositoryImpl")
    private UserDAO userDAO;
    private UserDTO userDTO;
    public UserDTO show(){
        userDTO = new UserDTO();
        userDTO.setUsers(userDAO.findAll());
        return userDTO;
    }

    public void them(User user){
        userDAO.insert(user);
    }

    public User findById(int id){
        User user = userDAO.findById(id);
        return user;
    }

    public void updated(User user){
        userDAO.update(user);
    }

    public void deleteById(int id){
        userDAO.delete(id);
    }
}
