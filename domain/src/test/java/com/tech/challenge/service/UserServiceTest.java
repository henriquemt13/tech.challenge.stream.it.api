package com.tech.challenge.service;

import com.tech.challenge.exception.BadRequestException;
import com.tech.challenge.fixture.UserFixture;
import com.tech.challenge.persistence.UserPersistence;
import com.tech.challenge.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserPersistence persistence;

    @Test
    void saveShouldRunAsExpected() {
        when(service.findByUsername(anyString())).thenReturn(Optional.empty());
        when(persistence.save(any())).thenReturn(UserFixture.newUser());

        var result = service.save(UserFixture.newUser());

        verify(persistence, times(1)).save(any());
        assertEquals(result, UserFixture.newUser());
    }

    @Test
    void saveShouldThrowBadRequestException() {
        when(service.findByUsername(anyString())).thenReturn(Optional.of(UserFixture.newUser()));

        assertThrows(BadRequestException.class, () -> service.save(UserFixture.newUser()));
    }

    @Test
    void findById() {

        when(persistence.findById(anyLong())).thenReturn(Optional.of(UserFixture.newUser()));

        var result = service.findById(1L);

        assertEquals(result.get(), UserFixture.newUser());
    }

    @Test
    void findByUsername() {

        when(persistence.findByUsername(anyString())).thenReturn(Optional.of(UserFixture.newUser()));

        var result = service.findByUsername("test");

        assertEquals(result.get(), UserFixture.newUser());
    }
}