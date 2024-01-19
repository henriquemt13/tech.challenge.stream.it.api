package com.tech.challenge.service;

import com.tech.challenge.exception.BadRequestException;
import com.tech.challenge.fixture.VideoCategoriesFixture;
import com.tech.challenge.persistence.VideoCategoriesPersistence;
import com.tech.challenge.service.impl.VideoCategoriesServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VideoCategoriesServiceTest {

    @InjectMocks
    private VideoCategoriesServiceImpl service;

    @Mock
    private VideoCategoriesPersistence persistence;

    @Test
    void saveShouldRunAsExpected() {
        when(service.findByVideoId(anyLong())).thenReturn(List.of());
        doNothing().when(persistence).save(any());

        assertDoesNotThrow(() -> service.save(1L, List.of(1L)));
    }

    @Test
    void saveShouldThrowBadRequestException() {
        when(service.findByVideoId(anyLong())).thenReturn(List.of(VideoCategoriesFixture.newVideoCategories()));
        assertThrows(BadRequestException.class, () -> service.save(1L, List.of(1L)));
    }

    @Test
    void findByVideoIdShouldRunAsExpected() {
        when(persistence.findByVideoId(anyLong())).thenReturn(List.of(VideoCategoriesFixture.newVideoCategories()));

        var result = service.findByVideoId(1L);

        assertEquals(result, List.of(VideoCategoriesFixture.newVideoCategories()));
        verify(persistence, times(1)).findByVideoId(anyLong());
    }

    @Test
    void findByCategoryIdIn() {
        when(persistence.findByCategoryIdIn(any())).thenReturn(List.of(VideoCategoriesFixture.newVideoCategories()));

        var result = service.findByCategoryIdIn(List.of(1L));

        assertEquals(result, List.of(VideoCategoriesFixture.newVideoCategories()));
        verify(persistence, times(1)).findByCategoryIdIn(any());
    }
}