package com.hosthelperbackend.hosthelperbackend.Service;

import com.hosthelperbackend.hosthelperbackend.DTO.RemoteDTO;
import com.hosthelperbackend.hosthelperbackend.model.Remote;
import com.hosthelperbackend.hosthelperbackend.repository.RemoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RemoteService {

    private final RemoteRepository remoteRepository;

    public RemoteService(RemoteRepository remoteRepository) {
        this.remoteRepository = remoteRepository;
    }

    public List<Remote> getUserRemotes(UUID userId){
        return remoteRepository.findAllRemotesByUserID(userId);
    }

    public Remote addRemote(RemoteDTO dto){
        Remote remote = RemoteDTO.DTOToRemote(dto);
        remote.setUserId(dto.getUserId());
        return remoteRepository.save(remote);
    }

    public void updateRemote(UUID remoteId, RemoteDTO dto){
        remoteRepository.updateRemote(
                remoteId,
                dto.getNickname(),
                dto.getDescription(),
                dto.getIpAddress(),
                dto.getPort(),
                dto.getUsername(),
                dto.getRemotePassword()
        );
    }

    public void removeRemote(UUID remoteId){
        remoteRepository.deleteRemoteById(remoteId);
    }

}
