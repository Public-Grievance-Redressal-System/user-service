package com.backend.userservice.userservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ValidateTokenRequestDTO {
    private String token;
}
