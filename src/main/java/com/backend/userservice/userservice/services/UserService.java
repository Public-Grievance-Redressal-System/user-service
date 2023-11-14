package com.backend.userservice.userservice.services;

import com.backend.userservice.userservice.dtos.UserDTO;
import com.backend.userservice.userservice.exceptions.UserNotFoundException;
import com.backend.userservice.userservice.models.Role;
import com.backend.userservice.userservice.models.User;
import com.backend.userservice.userservice.repositories.RoleRepository;
import com.backend.userservice.userservice.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @SneakyThrows
    public UserDTO getUserDetails(UUID id) {
        Optional<User> userById = userRepository.findById(id);
        if (userById.isEmpty()) {
            throw new UserNotFoundException("User doesn't exists");
        }
        return userById.map(UserDTO::from).orElse(null);
    }

    public UserDTO setUserRoles(UUID userId, List<UUID> roleIds) {
        Optional<User> userById = userRepository.findById(userId);
        if (userById.isEmpty()) {
            return null;
        }

        List<Role> allByIdIn = roleRepository.findAllByIdIn(roleIds);
        User user = userById.get();
        user.setRoles(Set.copyOf(allByIdIn));
        userRepository.save(user);

        return UserDTO.from(user);
    }

}
