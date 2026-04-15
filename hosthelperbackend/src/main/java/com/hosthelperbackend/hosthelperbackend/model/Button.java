package com.hosthelperbackend.hosthelperbackend.model;

import jakarta.persistence.*;


import java.util.UUID;

@Entity
@Table(name="manual_buttons")
public class Button {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID buttonId;

    private UUID userId;

    private String buttonName;

    private String command;

    public Button(UUID buttonId, UUID userId, String buttonName, String command) {
        this.buttonId = buttonId;
        this.userId = userId;
        this.buttonName = buttonName;
        this.command = command;
    }

    public Button() {

    }

    public UUID getButtonId() {
        return buttonId;
    }

    public void setButtonId(UUID buttonId) {
        this.buttonId = buttonId;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getButtonName() {
        return buttonName;
    }

    public void setButtonName(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
