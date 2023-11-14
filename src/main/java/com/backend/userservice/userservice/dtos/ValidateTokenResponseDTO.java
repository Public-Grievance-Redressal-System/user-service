package com.backend.userservice.userservice.dtos;

import com.backend.userservice.userservice.enums.SessionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidateTokenResponseDTO {
    private SessionStatus status;
}
