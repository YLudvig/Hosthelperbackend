package com.hosthelperbackend.hosthelperbackend.Service;

import com.hosthelperbackend.hosthelperbackend.DTO.UserDTO;
import com.hosthelperbackend.hosthelperbackend.model.User;
import com.hosthelperbackend.hosthelperbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Method to register/create a user/profile
    public User registerUser(UserDTO dto){
        User user = UserDTO.DTOToUser(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        return userRepository.save(user);
    }

    // Login method, checks that hashed input password matches the hashed password stored in db
    public boolean login(UserDTO dto){
        return userRepository.findByName(dto.getName())
                .map(user -> passwordEncoder.matches(dto.getPassword(), user.getPassword()))
                .orElse(false);
    }
}
