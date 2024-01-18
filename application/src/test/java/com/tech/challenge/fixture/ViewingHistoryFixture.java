package com.tech.challenge.fixture;

import com.tech.challenge.model.ViewingHistory;

import java.time.LocalDateTime;

public class ViewingHistoryFixture {
    public ViewingHistoryFixture() {

    }
    public static ViewingHistory newViewHistory() {
        return new ViewingHistory(1L, 1L, 1L,
                LocalDateTime.of(2024, 01, 14, 00, 00));
    }
}
