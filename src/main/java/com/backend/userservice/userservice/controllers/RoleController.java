package com.backend.userservice.userservice.controllers;


import com.backend.userservice.userservice.dtos.CreateRoleRequestDto;
import com.backend.userservice.userservice.models.Role;
import com.backend.userservice.userservice.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RoleController {

    private RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> createRole(@RequestBody CreateRoleRequestDto request) {
        Role role = roleService.createRole(request.getName());
        return new ResponseEntity<>(role, HttpStatus.OK);
    }
}
