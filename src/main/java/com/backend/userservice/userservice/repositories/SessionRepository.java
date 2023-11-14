package com.backend.userservice.userservice.repositories;

import com.backend.userservice.userservice.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SessionRepository extends JpaRepository<Session, UUID> {
    Optional<Session> findByTokenAndUserId(String token, UUID user_id);
}
