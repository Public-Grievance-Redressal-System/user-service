package com.backend.userservice.userservice.dtos;

import lombok.Data;

@Data
public class SignUpRequestDTO {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
}
