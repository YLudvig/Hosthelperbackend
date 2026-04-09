package com.hosthelperbackend.hosthelperbackend.DTO;

import com.hosthelperbackend.hosthelperbackend.model.Remote;

import java.util.UUID;

public class RemoteDTO {
    private UUID remoteId;

    private UUID userId;

    private String nickname;
    private String ipAddress;
    private int port;
    private String username;
    private String remotePassword;

    public static Remote DTOToRemote(RemoteDTO remoteDTO){
        Remote remote = new Remote();
        remote.setNickname(remoteDTO.getNickname());
        remote.setIpAddress(remoteDTO.getIpAddress());
        remote.setPort(22);
        remote.setUsername(remoteDTO.getUsername());
        remote.setRemotePassword(remoteDTO.getRemotePassword());
        return remote; 
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
