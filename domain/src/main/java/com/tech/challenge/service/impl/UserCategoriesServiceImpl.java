package com.tech.challenge.service.impl;

import com.tech.challenge.exception.BadRequestException;
import com.tech.challenge.model.UserCategories;
import com.tech.challenge.persistence.UserCategoriesPersistence;
import com.tech.challenge.service.UserCategoriesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class UserCategoriesServiceImpl implements UserCategoriesService {

    private final UserCategoriesPersistence persistence;

    @Override
    public UserCategories save(Long userId, Long categoryId) {
        findByUserId(userId).forEach(uc -> {
            if (Objects.equals(uc.getCategoryId(), categoryId)) {
                throw new BadRequestException(String.format("User ID %d has already liked Category ID %d",
                        userId, categoryId));
            }
        });
        UserCategories userCategories = new UserCategories(userId, categoryId);
        return persistence.save(userCategories);
    }

    @Override
    public List<UserCategories> findByUserId(Long userId) {
        return persistence.findByUserId(userId);
    }

}
