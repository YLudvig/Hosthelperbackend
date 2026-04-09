package com.hosthelperbackend.hosthelperbackend.DTO;

import com.hosthelperbackend.hosthelperbackend.model.User;

import java.util.UUID;

public class UserDTO {

    private UUID userId;
    private String name;
    private String password;

    public static User DTOToUser(UserDTO userDTO){
        User user = new User();
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    public UserDTO(String name, String password){
        this.name = name;
        this.password = password;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
