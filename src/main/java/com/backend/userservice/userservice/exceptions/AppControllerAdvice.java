package com.backend.userservice.userservice.exceptions;


import com.backend.userservice.userservice.dtos.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppControllerAdvice {

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ExceptionDTO> handleInvalidPasswordException(InvalidPasswordException exception) {
        return new ResponseEntity<>(new ExceptionDTO(exception.getMessage(), HttpStatus.UNAUTHORIZED), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidToken.class)
    public ResponseEntity<ExceptionDTO> handleInvalidTokenException(InvalidToken exception) {
        return new ResponseEntity<>(new ExceptionDTO(exception.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleUserNotFoundException(UserNotFoundException exception) {
        return new ResponseEntity<>(new ExceptionDTO(exception.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }
}
