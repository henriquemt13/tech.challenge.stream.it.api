package com.tech.challenge.controller.handler;

import com.tech.challenge.dto.response.ErrorResponseDTO;
import com.tech.challenge.exception.BadRequestException;
import com.tech.challenge.exception.NotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ControllerAdvisorTest {

    private final ControllerAdvisor controllerAdvisor = new ControllerAdvisor();

    @Test
    void handleNotFoundExceptionShouldReturnNotFoundResponse() {
        NotFoundException exception = new NotFoundException("Not Found Message");
        WebRequest request = mock(WebRequest.class);
        ResponseEntity<ErrorResponseDTO> responseEntity = controllerAdvisor.handleNotFoundException(exception, request);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        assertEquals("Not Found Message", responseEntity.getBody().getMessage());
    }

    @Test
    void handleBadRequestExceptionShouldReturnBadRequestResponse() {
        BadRequestException exception = new BadRequestException("Bad Request Message");
        WebRequest request = mock(WebRequest.class);

        ResponseEntity<ErrorResponseDTO> responseEntity = controllerAdvisor.handleBadRequestException(exception, request);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Bad Request Message", responseEntity.getBody().getMessage());
    }

    @Test
    void handleMalformedURLExceptionShouldReturnBadRequestResponse() {
        MalformedURLException exception = new MalformedURLException("Malformed URL Message");
        WebRequest request = mock(WebRequest.class);

        ResponseEntity<ErrorResponseDTO> responseEntity = controllerAdvisor.handleMalformedURLException(exception, request);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Malformed URL Message", responseEntity.getBody().getMessage());
    }

    @Test
    void handleConstraintViolationExceptionShouldReturnBadRequestResponse() {
        ConstraintViolationException exception = new ConstraintViolationException("Constraint Violation Message", null);
        WebRequest request = mock(WebRequest.class);

        ResponseEntity<ErrorResponseDTO> responseEntity =
                controllerAdvisor.handleConstraintViolationException(exception, request);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Constraint Violation Message", responseEntity.getBody().getMessage());
    }
}