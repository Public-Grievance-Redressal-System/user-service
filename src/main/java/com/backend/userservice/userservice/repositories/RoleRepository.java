package com.backend.userservice.userservice.repositories;

import com.backend.userservice.userservice.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    List<Role> findAllByIdIn(List<UUID> ids);
}
