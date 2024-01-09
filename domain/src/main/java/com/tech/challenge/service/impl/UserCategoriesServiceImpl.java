package com.tech.challenge.service.impl;

import com.tech.challenge.model.LikeOptionEnum;
import com.tech.challenge.model.UserCategories;
import com.tech.challenge.persistence.UserCategoryPersistence;
import com.tech.challenge.service.UserCategoriesService;

import java.util.List;

public class UserCategoriesServiceImpl implements UserCategoriesService {

    private UserCategoryPersistence persistence;

    @Override
    public List<UserCategories> findByUserId(Long userId) {
        return persistence.findByUserId(userId);
    }

    @Override
    public List<UserCategories> findByUserIdAndLikeOption(Long userId, LikeOptionEnum likeOptionEnum) {
        return persistence.findByUserIdAndLikeOption(userId, likeOptionEnum);
    }
}
