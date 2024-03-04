package com.spring.gokul.Service;

import java.util.List;

import com.spring.gokul.dto.UserDTO;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUser();

}
