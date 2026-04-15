package com.hosthelperbackend.hosthelperbackend.repository;

import com.hosthelperbackend.hosthelperbackend.model.Button;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ButtonRepository extends JpaRepository<Button, UUID> {

    @Query(value = """
        SELECT *
        FROM manual_buttons
        WHERE user_id = :userId
    """, nativeQuery = true)
    List<Button> findAllRemotesByUserId(UUID userId);


    @Modifying
    @Transactional
    @Query(value = """
        UPDATE manual_buttons 
        SET button_name = :buttonName, command = :command
    """, nativeQuery = true)
    void updateButton(@Param("buttonId") UUID buttonId,
                      @Param("buttonName") String buttonName,
                      @Param("command") String command);

    @Modifying
    @Transactional
    @Query(value = """
            DELETE FROM manual_buttons
            WHERE button_id = :buttonId
    """, nativeQuery = true)
    void deleteButtonById(@Param("buttonId") UUID buttonId);
}
