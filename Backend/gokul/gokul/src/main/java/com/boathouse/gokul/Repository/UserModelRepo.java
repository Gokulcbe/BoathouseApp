package com.boathouse.gokul.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boathouse.gokul.Model.User;
import com.boathouse.gokul.Model.UserModel;

public interface UserModelRepo extends JpaRepository<UserModel,Integer> {
     Optional<UserModel> findByUser(User user);
    Optional<UserModel> findByUserEmail(String email);
}