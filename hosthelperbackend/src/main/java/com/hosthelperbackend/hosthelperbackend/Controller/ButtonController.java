package com.hosthelperbackend.hosthelperbackend.Controller;


import com.hosthelperbackend.hosthelperbackend.DTO.ButtonDTO;
import com.hosthelperbackend.hosthelperbackend.Service.ButtonService;
import com.hosthelperbackend.hosthelperbackend.model.Button;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/button")
public class ButtonController {

    private final ButtonService buttonService;

    public ButtonController(ButtonService buttonService){
        this.buttonService = buttonService;
    }

    // Endpoint for users to create a button
    @PostMapping("/add")
    public ResponseEntity<Button> addButton(@RequestBody ButtonDTO dto){
        return ResponseEntity.status(201).body(buttonService.addButton(dto));
    }

    // Endpoint for user to get all their buttons
    @GetMapping("/getButtons/{userId}")
    public ResponseEntity<List<Button>> getbuttons(@PathVariable UUID userId){
        return ResponseEntity.ok(buttonService.getUserButtons(userId));
    }

    // Endpoint for user to update an existing button
    @PutMapping("/update/{buttonId}")
    public ResponseEntity<Map<String, String>> updateButton(@PathVariable UUID buttonId, @RequestBody ButtonDTO dto){
        buttonService.updateButton(buttonId, dto);
        return ResponseEntity.ok(Map.of("message", "Button updated successfully!"));
    }

    // Endpoint for user to delete a button
    @DeleteMapping("/delete/{buttonId}")
    public ResponseEntity<Map<String, String>> deleteButton(@PathVariable UUID buttonId){
        buttonService.removeButton(buttonId);
        return ResponseEntity.ok(Map.of("message","Button removed!"));
    }
    
}
