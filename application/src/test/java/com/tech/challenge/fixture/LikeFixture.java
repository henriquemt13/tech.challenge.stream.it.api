package com.tech.challenge.fixture;

import com.tech.challenge.model.Like;
import com.tech.challenge.model.LikeOptionEnum;

import java.time.LocalDateTime;

public class LikeFixture {

    public LikeFixture() {
    }

    public static Like newLike() {
        return new Like(1L, 1L, 1L,
                LikeOptionEnum.LIKE,  LocalDateTime.of(2024, 01, 14, 00, 00));
    }

    public static Like newDislike() {
        return new Like(1L, 1L, 1L,
                LikeOptionEnum.DISLIKE,  LocalDateTime.of(2024, 01, 14, 00, 00));
    }
}
