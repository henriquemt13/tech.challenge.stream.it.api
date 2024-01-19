package com.tech.challenge.fixture;

import com.tech.challenge.model.VideoCategories;

import java.time.LocalDateTime;

public class VideoCategoriesFixture {
    public VideoCategoriesFixture() {
    }

    public static VideoCategories newVideoCategories() {
        return new VideoCategories(1L, 1L, 1L, LocalDateTime.of(2024, 1, 14, 0, 0));
    }
}
