package com.backend.userservice.userservice.controllers;


import com.backend.userservice.userservice.dtos.*;
import com.backend.userservice.userservice.enums.SessionStatus;
import com.backend.userservice.userservice.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginRequestDTO request) {
        return authService.login(request.getEmail(), request.getPassword());
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDTO request) {
        return authService.logout(request.getToken());
    }

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody SignUpRequestDTO request) {
        UserDTO userDto = authService.signUp(
                request.getEmail(),
                request.getPassword(),
                request.getPhoneNumber(),
                request.getName(),
                request.getAddress()
        );
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/validate")
    public ResponseEntity<ValidateTokenResponseDTO> validateToken(@RequestBody ValidateTokenRequestDTO request) {
        SessionStatus sessionStatus = authService.validate(request.getToken());
        return new ResponseEntity<>(new ValidateTokenResponseDTO(sessionStatus), HttpStatus.OK);

    }
}
