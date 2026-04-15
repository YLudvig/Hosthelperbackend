package com.hosthelperbackend.hosthelperbackend.DTO;

import com.hosthelperbackend.hosthelperbackend.model.Button;

import java.util.UUID;

public class ButtonDTO {

    private UUID buttonId;

    private UUID userId;

    private String buttonName;

    private String command;

    public static Button DTOToButton(ButtonDTO buttonDTO){
        Button button = new Button();
        button.setButtonName(buttonDTO.getButtonName());
        button.setCommand(buttonDTO.getCommand());
        return button;
    }

    public ButtonDTO(UUID userId, String buttonName, String command) {
        this.userId = userId;
        this.buttonName = buttonName;
        this.command = command;
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
