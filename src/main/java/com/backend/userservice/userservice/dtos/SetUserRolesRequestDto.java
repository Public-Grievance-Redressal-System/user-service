package com.backend.userservice.userservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class SetUserRolesRequestDto {
    private List<UUID> roleIds;
}
