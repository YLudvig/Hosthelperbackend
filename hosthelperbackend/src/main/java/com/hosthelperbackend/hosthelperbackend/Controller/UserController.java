package com.hosthelperbackend.hosthelperbackend.Controller;

import com.hosthelperbackend.hosthelperbackend.DTO.UserDTO;
import com.hosthelperbackend.hosthelperbackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserDTO dto){
        try {
            userService.registerUser(dto);
            return ResponseEntity.status(201).body("User created");
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error creating user, possible duplicate username");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDTO dto){
        return userService.login(dto)
                ? ResponseEntity.ok("Login success.")
                : ResponseEntity.status(401).body("Failure");
    }

}
