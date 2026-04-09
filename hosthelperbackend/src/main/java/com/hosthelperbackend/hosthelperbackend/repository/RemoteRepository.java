package com.hosthelperbackend.hosthelperbackend.repository;

import com.hosthelperbackend.hosthelperbackend.model.Remote;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface RemoteRepository extends JpaRepository<Remote, UUID> {

    //Query to get all of users remotes
    @Query(value = """
            SELECT * 
            FROM remote
            WHERE user_id = :userId
    """, nativeQuery = true)
    List<Remote> findAllRemotesByUserID(UUID userId);


    //Query to delete remotes by remoteId
    @Modifying
    @Transactional
    @Query(value = """
            DELETE FROM remote
            WHERE remote_id = :remoteId
    """, nativeQuery = true)
    void deleteRemoteById(@Param("remoteId") UUID remoteId);


    //Query to update a remote
    @Modifying
    @Transactional
    @Query(value = """
            UPDATE remote 
            SET nickname = :nickname, ip_address = :ipAddress, port = :port, 
            username = :username, remote_password = :remotePassword
            WHERE remote_id = :remoteId
    """, nativeQuery = true)
    void updateRemote(@Param("remoteId") UUID remoteId,
                      @Param("nickname") String nickname,
                      @Param("ipAddress") String ipAddress,
                      @Param("port") int port,
                      @Param("username") String username,
                      @Param("remotePassword") String remotePassword);

}
