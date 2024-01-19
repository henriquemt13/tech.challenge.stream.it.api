package com.tech.challenge.fixture;

import com.tech.challenge.model.Category;

import java.time.LocalDateTime;

public class CategoryFixture {

    public CategoryFixture() {

    }

    public static Category newCategory() {
        return new Category(1L, "Music", LocalDateTime.of(2024, 01, 14, 00, 00));
    }
}
