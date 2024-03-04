package com.boathouse.gokul.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boathouse.gokul.Model.User;

public interface UserRepository extends JpaRepository<User, String>{

}
