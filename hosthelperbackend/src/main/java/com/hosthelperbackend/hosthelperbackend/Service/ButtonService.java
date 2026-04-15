package com.hosthelperbackend.hosthelperbackend.Service;

import com.hosthelperbackend.hosthelperbackend.DTO.ButtonDTO;
import com.hosthelperbackend.hosthelperbackend.model.Button;
import com.hosthelperbackend.hosthelperbackend.repository.ButtonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ButtonService {

    private final ButtonRepository buttonRepository;

    public ButtonService(ButtonRepository buttonRepository){
        this.buttonRepository = buttonRepository;
    }

    public List<Button> getUserButtons(UUID userId) {
        return buttonRepository.findAllRemotesByUserId(userId);
    }

    public Button addButton(ButtonDTO dto) {
        Button button = ButtonDTO.DTOToButton(dto);
        button.setUserId(dto.getUserId());
        return buttonRepository.save(button);
    }


    public void updateButton(UUID buttonId, ButtonDTO dto) {
        buttonRepository.updateButton(
                buttonId,
                dto.getButtonName(),
                dto.getCommand()
        );
    }

    public void removeButton(UUID buttonId) {
        buttonRepository.deleteButtonById(buttonId);
    }
}
