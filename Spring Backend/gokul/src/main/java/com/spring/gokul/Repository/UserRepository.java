package com.spring.gokul.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.gokul.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
