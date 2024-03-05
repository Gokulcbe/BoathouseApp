package com.boathouse.gokul.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boathouse.gokul.Model.AdminModel;
import com.boathouse.gokul.Model.User;

public interface AdminRepo extends JpaRepository<AdminModel,Integer> {
   Optional <AdminModel>  findByUser(User user);
   Optional <AdminModel> findByUserEmail(String email);
}