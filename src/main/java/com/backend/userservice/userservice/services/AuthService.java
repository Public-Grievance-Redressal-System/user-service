package com.backend.userservice.userservice.services;

import com.backend.userservice.userservice.dtos.UserDTO;
import com.backend.userservice.userservice.enums.SessionStatus;
import com.backend.userservice.userservice.exceptions.InvalidPasswordException;
import com.backend.userservice.userservice.models.Session;
import com.backend.userservice.userservice.models.User;
import com.backend.userservice.userservice.repositories.SessionRepository;
import com.backend.userservice.userservice.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMapAdapter;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    private SessionRepository sessionRepository;
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;
    private JWTService jwtService;

    @SneakyThrows
    public ResponseEntity<UserDTO> login(String email, String password) {

        Optional<User> userOptional = userRepository.findByEmail(email);

        if (userOptional.isEmpty()) {
            return null;
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidPasswordException("Wrong password");
        }

        String token = jwtService.generateJWTToken(user);

        Session session = new Session();
        session.setUser(user);
        session.setToken(token);
        session.setSessionStatus(SessionStatus.ACTIVE);

        sessionRepository.save(session);

        UserDTO userDTO = UserDTO.from(user);

        MultiValueMapAdapter<String, String> headers = new MultiValueMapAdapter<>(new HashMap<>());
        headers.add(HttpHeaders.SET_COOKIE, "auth-token:" + token);

        return new ResponseEntity<>(userDTO, headers, HttpStatus.OK);
    }

    public ResponseEntity<Void> logout(String token, UUID userId) {
        Optional<Session> sessionOptional = sessionRepository.findByTokenAndUserId(token, userId);

        if (sessionOptional.isEmpty()) {
            return null;
        }

        Session session = sessionOptional.get();

        session.setSessionStatus(SessionStatus.ENDED);

        sessionRepository.save(session);

        return ResponseEntity.ok().build();
    }

    public UserDTO signUp(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        User savedUser = userRepository.save(user);

        return UserDTO.from(savedUser);
    }

    public SessionStatus validate(String token, UUID userId) {
        Optional<Session> sessionOptional = sessionRepository.findByTokenAndUserId(token, userId);

        if (sessionOptional.isEmpty()) {
            return null;
        }

        return SessionStatus.ACTIVE;
    }


}
