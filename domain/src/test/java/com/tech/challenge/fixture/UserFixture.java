package com.tech.challenge.fixture;

import com.tech.challenge.model.User;

import java.time.LocalDateTime;

public class UserFixture {
    public UserFixture() {
    }

    public static User newUser() {
        return new User(1L, "teste", LocalDateTime.of(2024, 1, 14, 0, 0));
    }
}
