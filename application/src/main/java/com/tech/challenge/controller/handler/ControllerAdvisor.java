package com.tech.challenge.controller.handler;

import com.tech.challenge.dto.response.ErrorResponseDTO;
import com.tech.challenge.exception.BadRequestException;
import com.tech.challenge.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.MalformedURLException;

@ControllerAdvice
@Slf4j
public class ControllerAdvisor {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFoundException(
            NotFoundException ex, WebRequest request) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponseDTO(
                        ex.getMessage()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDTO> handleBadRequestException(
            BadRequestException ex, WebRequest request) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponseDTO(
                        ex.getMessage()));
    }

    @ExceptionHandler(MalformedURLException.class)
    public ResponseEntity<ErrorResponseDTO> handleMalformedURLException(
            MalformedURLException ex, WebRequest request) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorResponseDTO(
                        ex.getMessage()));
    }

}
