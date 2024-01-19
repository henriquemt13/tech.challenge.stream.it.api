package com.tech.challenge.fixture;

import com.tech.challenge.model.Video;

import java.time.LocalDateTime;

public class VideoFixture {
    public VideoFixture() {
    }

    public static Video newVideo() {
        return new Video(1L, 1L,
                "video name test", "description test",
                "/path/url", LocalDateTime.of(2024, 01, 14, 00, 00));
    }
}
