package com.boathouse.gokul.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boathouse.gokul.Model.AdminModel;
import com.boathouse.gokul.Model.User;
import com.boathouse.gokul.Repository.AdminRepo;
import com.boathouse.gokul.Repository.UserRepository;

@Service
public class AdminService {
    @Autowired
    AdminRepo adminRepo;
    @Autowired
    UserRepository userRepo;

    public Optional<AdminModel> getAdmin(int id) {
        return adminRepo.findById(id);
    }

    // public String updateAdmin(AdminModel adminModel) {
    //     Optional<User> user = userRepo.findByEmail(adminModel.getUser().getEmail());
    //     if (user.isEmpty()) {
    //         return "User not found";
    //     }
    //     user.get().setName(adminModel.getUser().getName());
    //     userRepo.save(user.get());
    //     Optional<AdminModel> admin = adminRepo.findByUser(user.get());
    //     admin.get().setMobileNumber(adminModel.getMobileNumber());
    //     adminRepo.save(admin.get());
    //     return "Updated successfully";
    // }

}