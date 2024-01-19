package com.tech.challenge.service;

import com.tech.challenge.fixture.ViewingHistoryFixture;
import com.tech.challenge.persistence.ViewingHistoryPersistence;
import com.tech.challenge.service.impl.ViewingHistoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ViewingHistoryServiceTest {

    @InjectMocks
    private ViewingHistoryServiceImpl service;

    @Mock
    private ViewingHistoryPersistence persistence;

    @Test
    void findByUserIdShouldRunAsExpected() {

        when(persistence.findByUserId(anyLong())).thenReturn(List.of(ViewingHistoryFixture.newViewHistory()));

        var result = service.findByUserId(1L);

        assertEquals(result, List.of(ViewingHistoryFixture.newViewHistory()));
    }

    @Test
    void addViewShouldRunAsExpected() {
        doNothing().when(persistence).save(anyLong(), anyLong());

        assertDoesNotThrow(() -> service.addView(1L, 1L));
    }


    @Test
    void findTotalViewsShouldRunAsExpected() {
        when(persistence.totalViews()).thenReturn(1L);

        var result = service.findTotalViews();

        assertEquals(1L, result);

    }
}