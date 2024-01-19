package com.tech.challenge.fixture;

import com.tech.challenge.model.UserCategories;

public class UserCategoriesFixture {

    public UserCategoriesFixture() {

    }

    public static UserCategories newUserCategoriesFixture() {
        return new UserCategories(1L, 1L);
    }
}
