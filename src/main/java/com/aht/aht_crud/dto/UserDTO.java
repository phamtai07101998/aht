package com.aht.aht_crud.dto;

import com.aht.aht_crud.model.User;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private List<User> users;
}
