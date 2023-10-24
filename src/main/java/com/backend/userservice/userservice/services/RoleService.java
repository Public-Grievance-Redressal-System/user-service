package com.backend.userservice.userservice.services;

import com.backend.userservice.userservice.models.Role;
import com.backend.userservice.userservice.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {
    private RoleRepository roleRepository;

    public Role createRole(String role) {
        Role entity = new Role();
        entity.setRole(role);
        return roleRepository.save(entity);
    }
}
