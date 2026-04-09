package com.hosthelperbackend.hosthelperbackend.repository;

import com.hosthelperbackend.hosthelperbackend.model.Remote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RemoteRepository extends JpaRepository<Remote, UUID> {

    @Query(value = """
            SELECT * 
            FROM remote
            WHERE user_id = :userId
    """, nativeQuery = true)
    List<Remote> findAllRemotesByUserID(UUID userId);

}
