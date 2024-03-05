package com.boathouse.gokul.Service;


import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.boathouse.gokul.dto.request.AuthenticationRequest;
import com.boathouse.gokul.dto.request.RegisterRequest;
import com.boathouse.gokul.dto.response.AuthenticationResponse;
import com.boathouse.gokul.Model.AdminModel;
import com.boathouse.gokul.Model.Role;
import com.boathouse.gokul.Model.User;
import com.boathouse.gokul.Model.UserModel;
import com.boathouse.gokul.Repository.AdminRepo;
import com.boathouse.gokul.Repository.UserModelRepo;
import com.boathouse.gokul.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
        private final UserModelRepo userModelRepository;
        private final AdminRepo adminModelRepository;
        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

        public AuthenticationResponse register(RegisterRequest request) {
                if (request.getUserRole().equals("user")) {
                        var user = User
                                        .builder()
                                        .name(request.getName())
                                        .email(request.getEmail())
                                        .password(passwordEncoder.encode(request.getPassword()))
                                        .role(com.boathouse.gokul.enumerated.Role.USER)
                                        .build();
                        Optional<User> existing = userRepository.findByEmail(request.getEmail());
                        if (!existing.isEmpty()) {
                                return AuthenticationResponse.builder()
                                                .token("Email Already exists")
                                                .build();
                        }
                        User savedUser = userRepository.save(user);
                        UserModel userModel = new UserModel();
                        userModel.setMobileNumber(request.getMobileNumber());
                        userModel.setUser(savedUser);
                        userModelRepository.save(userModel);
                        var jwtToken = jwtService.generateToken(user);

                        return AuthenticationResponse.builder()
                                        .token(jwtToken)

                                        .build();
                }
                var user = User
                                .builder()
                                .name(request.getName())
                                .email(request.getEmail())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .role(com.boathouse.gokul.enumerated.Role.ADMIN)
                                .build();
                Optional<User> existing = userRepository.findByEmail(request.getEmail());
                if (!existing.isEmpty()) {
                        return AuthenticationResponse.builder()
                                        .token("Email Already exists")
                                        .build();
                }
                User savedUser = userRepository.save(user);
                AdminModel adminModel = new AdminModel();
                adminModel.setMobileNumber(request.getMobileNumber());
                adminModel.setUser(savedUser);
                adminModelRepository.save(adminModel);
                var jwtToken = jwtService.generateToken(user);

                return AuthenticationResponse.builder()
                                .token(jwtToken)

                                .build();
        }

        public AuthenticationResponse authenticate(AuthenticationRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
                var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
                if (request.getRole().equals("admin") && user.getRole() != com.boathouse.gokul.enumerated.Role.ADMIN) {
                        return AuthenticationResponse.builder()
                                        .token("Invalid Credentials")
                                        .build();
                }
                if (request.getRole().equals("user") && user.getRole() != com.boathouse.gokul.enumerated.Role.USER) {
                        return AuthenticationResponse.builder()
                                        .token("Invalid Credentials")
                                        .build();
                }
                var jwtToken = jwtService.generateToken(user);
                var userRole = (user.getRole() == com.boathouse.gokul.enumerated.Role.ADMIN) ? "admin" : "user";
                return AuthenticationResponse.builder()
                                .token(jwtToken)
                                .userRole(userRole)
                                .build();
        }
}