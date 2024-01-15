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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
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
}