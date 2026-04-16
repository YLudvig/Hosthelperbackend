package com.hosthelperbackend.hosthelperbackend.repository;

import com.hosthelperbackend.hosthelperbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    // Methods to get User by name
    @Query(value = """

            SELECT u.*
            FROM app_user u
            WHERE u.name = :name
    """, nativeQuery = true)
    Optional<User> findByName(String name);

    boolean existsByName(String name);
}
