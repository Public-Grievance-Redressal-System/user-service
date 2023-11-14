package com.backend.userservice.userservice.dtos;

import com.backend.userservice.userservice.models.Role;
import com.backend.userservice.userservice.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
public class UserDTO {
    private String email;
    private String phoneNumber;
    private Set<Role> roles;
    private String name;
    private String address;

    public static UserDTO from(User user) {
        return new UserDTO(
                user.getEmail(),
                user.getPhoneNumber(),
                user.getRoles(),
                user.getName(),
                user.getAddress()
        );
    }
}
