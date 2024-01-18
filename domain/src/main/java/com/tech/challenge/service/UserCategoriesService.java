package com.tech.challenge.service;

import com.tech.challenge.model.LikeOptionEnum;
import com.tech.challenge.model.UserCategories;

import java.util.List;

public interface UserCategoriesService {

    UserCategories save(Long userId, Long categoryId);

    List<UserCategories> findByUserId(Long userId);

}
