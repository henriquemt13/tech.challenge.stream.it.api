package com.tech.challenge.adapter;

import com.tech.challenge.model.LikeOptionEnum;
import com.tech.challenge.model.UserCategories;
import com.tech.challenge.persistence.UserCategoryPersistence;
import com.tech.challenge.repository.UserCategoriesRepository;

import java.util.List;

public class UserCategoryAdapter implements UserCategoryPersistence {

    private UserCategoriesRepository repository;

    @Override
    public List<UserCategories> findByUserId(Long userId) {
        return null;
    }

    @Override
    public List<UserCategories> findByUserIdAndLikeOption(Long userId, LikeOptionEnum likeOptionEnum) {
        return null;
    }
}
