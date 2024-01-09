package com.tech.challenge.service;

import com.tech.challenge.model.LikeOptionEnum;
import com.tech.challenge.model.UserCategories;

import java.util.List;

public interface UserCategoriesService {

    List<UserCategories> findByUserId(Long userId);

    List<UserCategories> findByUserIdAndLikeOption(Long userId, LikeOptionEnum likeOptionEnum);
}
