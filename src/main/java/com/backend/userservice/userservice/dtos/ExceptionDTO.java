package com.backend.userservice.userservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ExceptionDTO {
    private String message;
    private HttpStatus status;
}
