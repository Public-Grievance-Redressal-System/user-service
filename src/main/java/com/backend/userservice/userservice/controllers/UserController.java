package com.backend.userservice.userservice.controllers;

import com.backend.userservice.userservice.dtos.SetUserRolesRequestDto;
import com.backend.userservice.userservice.dtos.UserDTO;
import com.backend.userservice.userservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserDetails(@PathVariable("id") UUID userId) {
        UserDTO userDto = userService.getUserDetails(userId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/{id}/roles")
    public ResponseEntity<UserDTO> setUserRoles(@PathVariable("id") UUID userId, @RequestBody SetUserRolesRequestDto request) {
        UserDTO userDto = userService.setUserRoles(userId, request.getRoleIds());
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
