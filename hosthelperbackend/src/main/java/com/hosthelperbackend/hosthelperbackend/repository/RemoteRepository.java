package com.hosthelperbackend.hosthelperbackend.repository;

import com.hosthelperbackend.hosthelperbackend.model.Remote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RemoteRepository extends JpaRepository<Remote, UUID> {

}
