package com.boathouse.gokul.Service;

import java.util.List;

import com.boathouse.gokul.dto.UserDTO;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(String email);

    List<UserDTO> getAllUser();

}
