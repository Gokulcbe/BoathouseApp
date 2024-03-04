package com.spring.gokul.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.gokul.Service.UserService;
import com.spring.gokul.dto.UserDTO;

import lombok.AllArgsConstructor;
import java.util.List;
// import org.hibernate.mapping.List;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@AllArgsConstructor
@RestController
@RequestMapping("/")
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> postMethodName(@RequestBody UserDTO userDTO) {
            UserDTO savedUser = userService.createUser(userDTO);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getEmployee(@PathVariable("id") Long id) {
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUser() {
        List<UserDTO> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }
    
    
    
}
