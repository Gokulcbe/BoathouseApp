package com.boathouse.gokul.Mapper;

import com.boathouse.gokul.Model.User;
import com.boathouse.gokul.dto.UserDTO;

public class UserMapper {

    public static UserDTO mapToUserDTO(User user){
        return new UserDTO(
            user.getEmail(),
            user.getPassword(),
            user.getUsername(),
            user.getPhoneno(),
            user.getFirstname(),
            user.getLastname(),
            user.getBirthday(),
            user.getGender(),
            user.getAddress(),
            user.getResidenttype(),
            user.getCity(),
            user.getZipcode()
        );
    }

    public static User mapToUser(UserDTO userDTO) {
        return new User(
            userDTO.getEmail(),
            userDTO.getPassword(),
            userDTO.getUsername(),
            userDTO.getPhoneno(),
            userDTO.getFirstname(),
            userDTO.getLastname(),
            userDTO.getBirthday(),
            userDTO.getGender(),
            userDTO.getAddress(),
            userDTO.getResidenttype(),
            userDTO.getCity(),
            userDTO.getZipcode()
        );
    }

}
