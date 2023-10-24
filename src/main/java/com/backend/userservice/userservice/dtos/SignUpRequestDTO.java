package com.backend.userservice.userservice.dtos;

import lombok.Data;

@Data
public class SignUpRequestDTO {
    private String email;
    private String password;
}
