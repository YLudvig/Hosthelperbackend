package com.hosthelperbackend.hosthelperbackend.model;

import jakarta.persistence.*;

import java.util.UUID;

//Entity for remotes (other computers and your own)
//For remotes we need to store info about the IP, the username and the password
//Also storing nickname, last checked timestamp description to enable user to clearly separate the pis
//Remotes is the name used in this name for computers/pis
@Entity
@Table(name="remote")
public class Remote {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID remoteId;

    private UUID userId;

    private String nickname;
    private String ipAddress;
    private int port;

    private String username;
    private String remotePassword;


    public Remote(UUID remoteId, UUID userId, String nickname, String ipAddress, int port, String username, String remotePassword) {
        this.remoteId = remoteId;
        this.userId = userId;
        this.nickname = nickname;
        this.ipAddress = ipAddress;
        this.port = port;
        this.username = username;
        this.remotePassword = remotePassword;
    }

    public Remote() {
        
    }

    public UUID getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(UUID remoteId) {
        this.remoteId = remoteId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRemotePassword() {
        return remotePassword;
    }

    public void setRemotePassword(String remotePassword) {
        this.remotePassword = remotePassword;
    }
}
