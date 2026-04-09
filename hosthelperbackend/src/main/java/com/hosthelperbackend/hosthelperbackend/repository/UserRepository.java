package com.hosthelperbackend.hosthelperbackend.repository;

import com.hosthelperbackend.hosthelperbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

// Methods to get User by name
public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(value = """

            SELECT u.*
            FROM app_user u
            WHERE u.name = :name
    """, nativeQuery = true)
    Optional<User> findByName(String name);

}
