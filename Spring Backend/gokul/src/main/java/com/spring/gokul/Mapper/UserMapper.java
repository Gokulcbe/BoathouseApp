package com.spring.gokul.Mapper;

import com.spring.gokul.Model.User;
import com.spring.gokul.dto.UserDTO;

public class UserMapper {

    public static UserDTO mapToUserDTO(User user){
        return new UserDTO(
            user.getId(),
            user.getEmail(),
            user.getPassword()
        );
    }

    public static User mapToUser(UserDTO userDTO) {
        return new User(
            userDTO.getId(),
            userDTO.getEmail(),
            userDTO.getPassword()
        );
    }

}
