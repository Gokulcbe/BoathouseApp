package com.spring.gokul.Service.impl;

import java.util.ArrayList;
import java.util.List;

// import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.spring.gokul.Exception.ResourceNotFoundException;
import com.spring.gokul.Mapper.UserMapper;
import com.spring.gokul.Model.User;
import com.spring.gokul.Repository.UserRepository;
import com.spring.gokul.Service.UserService;
import com.spring.gokul.dto.UserDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userrepo;

    @Override
    public UserDTO createUser(UserDTO userDTO){
        User user = UserMapper.mapToUser(userDTO);
        User savedUser = userrepo.save(user);
        return UserMapper.mapToUserDTO(savedUser);
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userrepo.findById(id)
                    .orElseThrow(
                        () -> new ResourceNotFoundException("user is not exist with given email : " +  id));
        return UserMapper.mapToUserDTO(user);       
    }

    @Override
    public List<UserDTO> getAllUser() {
       List<User> users = userrepo.findAll();
       List<UserDTO> userDTOs = new ArrayList<>();
       for(User user : users){
            userDTOs.add(UserMapper.mapToUserDTO(user));
       }
       return userDTOs;
    }


}
