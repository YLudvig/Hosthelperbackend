package com.hosthelperbackend.hosthelperbackend.Controller;

import com.hosthelperbackend.hosthelperbackend.DTO.UserDTO;
import com.hosthelperbackend.hosthelperbackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/auth")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody UserDTO dto) {
        try {
            userService.registerUser(dto);
            return ResponseEntity.status(201).body(Map.of("message", "User created"));
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(Map.of("message", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("message", "Error creating user, possibly duplicate username"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO dto){
        return userService.login(dto)
                .map(userId -> ResponseEntity.ok().body(Map.of(
                        "message", "Login successful",
                        "userId", userId
                )))
                .orElse(ResponseEntity.status(401).body(Map.of("message", "Login failed")));
    }

}
