package com.backend.userservice.userservice.services;

import com.backend.userservice.userservice.models.Role;
import com.backend.userservice.userservice.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.*;


@Service
public class JWTService {

    @Value("${jwt.secret}")
    private String jwtSecret;


    private SecretKey getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateJWTToken(User user) {

        return Jwts.builder().subject(user.getName())
                .claim("email", user.getEmail())
                .claim("id", user.getId().toString())
                .claim("phoneNumber", user.getPhoneNumber())
                .claim("name", user.getName())
                .claim("roles", user.getRoles().stream().map(Role::getRole).toList())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(
                        new Date(System.currentTimeMillis() + 3600 * 1000))
                .signWith(getSignKey()).compact();
    }

    public Optional<User> getUserFromToken(String token) {
        if (token == null || token.isEmpty()) {
            return Optional.empty();
        }

        try {
            Claims claims = Jwts
                    .parser()
                    .verifyWith(getSignKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();

            User user = new User();

            Object roles = claims.get("roles");

            if (roles instanceof Collection<?>) {
                user.setRoles(Set.copyOf((Collection<? extends Role>) roles));
            }
            user.setEmail(claims.get("email", String.class));
            user.setName(claims.get("name", String.class));
            user.setId(UUID.fromString(claims.get("id", String.class)));
            user.setPhoneNumber(claims.get("phoneNumber", String.class));
            return Optional.of(user);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }


    }

    public boolean validateToken(String token) {
        return false;
    }
}
