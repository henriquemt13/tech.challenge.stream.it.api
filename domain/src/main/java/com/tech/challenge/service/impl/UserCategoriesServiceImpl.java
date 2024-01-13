package com.tech.challenge.service.impl;

import com.tech.challenge.model.LikeOptionEnum;
import com.tech.challenge.model.UserCategories;
import com.tech.challenge.persistence.UserCategoryPersistence;
import com.tech.challenge.service.UserCategoriesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@AllArgsConstructor
public class UserCategoriesServiceImpl implements UserCategoriesService {

    private UserCategoryPersistence persistence;

    @Override
    public UserCategories save(Long userId, Long categoryId) {
        UserCategories userCategories = new UserCategories(userId, categoryId);
        return persistence.save(userCategories);
    }

    @Override
    public List<UserCategories> findByUserId(Long userId) {
        return persistence.findByUserId(userId);
    }

    @Override
    public List<UserCategories> findByUserIdAndLikeOption(Long userId, LikeOptionEnum likeOptionEnum) {
        return persistence.findByUserIdAndLikeOption(userId, likeOptionEnum);
    }
}
