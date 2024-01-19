package com.tech.challenge.fixture;

import com.tech.challenge.dto.SearchResultDTO;
import com.tech.challenge.model.Video;

import java.time.LocalDateTime;
import java.util.List;

public class VideoFixture {
    public VideoFixture() {
    }

    public static SearchResultDTO<Video> newVideoResult() {
        return new SearchResultDTO(
                List.of(new Video(1L, 1L,
                        "video name test", "description test",
                        "/path/url", LocalDateTime.of(2024, 01, 14, 00, 00))),
                1, 1L, 1, 1);
    }


    public static Video newVideo() {
        return new Video(1L, 1L,
                "video name test", "description test",
                "/path/url", LocalDateTime.of(2024, 01, 14, 00, 00));
    }
}
