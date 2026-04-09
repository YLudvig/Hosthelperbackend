package com.hosthelperbackend.hosthelperbackend.Controller;

import com.hosthelperbackend.hosthelperbackend.DTO.RemoteDTO;
import com.hosthelperbackend.hosthelperbackend.Service.RemoteService;
import com.hosthelperbackend.hosthelperbackend.model.Remote;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/remote")
public class RemoteController {

    private final RemoteService remoteService;

    public RemoteController(RemoteService remoteService) {
        this.remoteService = remoteService;
    }

    //Endpoint for users to create a remote
    @PostMapping("/add")
    public ResponseEntity<Remote> addRemote(@RequestBody RemoteDTO dto){
        return ResponseEntity.status(201).body(remoteService.addRemote(dto));
    }

    //Endpoint for user to get all their remotes
    @GetMapping("/getRemotes/{userId}")
    public ResponseEntity<List<Remote>> getRemotes(@PathVariable UUID userId){
        return ResponseEntity.ok(remoteService.getUserRemotes(userId));
    }

    //Endpoint for user to update an existing remote
    @PutMapping("/update/{remoteId}")
    public ResponseEntity<String> updateRemote(@PathVariable UUID remoteId, @RequestBody RemoteDTO dto){
        remoteService.updateRemote(remoteId, dto);
        return ResponseEntity.ok("Remote updated successfully!");
    }

    //Endpoint for user to delete a remote
    @DeleteMapping("/delete/{remoteId}")
    public ResponseEntity<String> deleteRemote(@PathVariable UUID remoteId){
        remoteService.removeRemote(remoteId);
        return ResponseEntity.ok("Remote removed!");
    }

}