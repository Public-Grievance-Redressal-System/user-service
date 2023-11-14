package com.backend.userservice.userservice.models;


import com.backend.userservice.userservice.enums.SessionStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "sessions")
@Getter
@Setter
public class Session extends BaseModel {
    @Column(columnDefinition = "longtext")
    private String token;
    private Date expiringAt;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.ORDINAL)
    private SessionStatus sessionStatus;
}
