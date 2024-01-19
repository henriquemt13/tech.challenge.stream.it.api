package com.tech.challenge.usecase;

import com.tech.challenge.exception.BadRequestException;
import com.tech.challenge.exception.NotFoundException;
import com.tech.challenge.fixture.UserFixture;
import com.tech.challenge.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserUseCasesTest {

    @InjectMocks
    private UserUseCases useCases;

    @Mock
    private UserService userService;

    @Test
    void findByIdShouldRunAsExpected() {
        when(userService.findById(anyLong())).thenReturn(Optional.of(UserFixture.newUser()));

        assertEquals(UserFixture.newUser(), useCases.findById(1L));
    }

    @Test
    void findByIdShouldThrowNotFoundException() {
        when(userService.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> useCases.findById(1L));
    }

    @Test
    void findByUsernameShouldRunAsExpected() {
        when(userService.findByUsername(anyString())).thenReturn(Optional.of(UserFixture.newUser()));

        assertEquals(Optional.of(UserFixture.newUser()), useCases.findByUsername("teste"));
    }

    @Test
    void saveUserShouldRunAsExpected() {
        when(useCases.findByUsername(anyString())).thenReturn(Optional.empty());

        assertDoesNotThrow(() -> useCases.saveUser(UserFixture.newUser()));

    }

    @Test
    void saveUserShouldThrowBadRequestException() {
        when(useCases.findByUsername(anyString())).thenReturn(Optional.of(UserFixture.newUser()));

        assertThrows(BadRequestException.class, () -> useCases.saveUser(UserFixture.newUser()));

    }
}