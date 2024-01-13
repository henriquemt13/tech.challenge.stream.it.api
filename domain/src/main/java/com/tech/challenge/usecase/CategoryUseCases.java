package com.tech.challenge.usecase;

import com.tech.challenge.model.Category;
import com.tech.challenge.model.UserCategories;
import com.tech.challenge.service.CategoryService;
import com.tech.challenge.service.UserCategoriesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CategoryUseCases {

    private UserUseCases userUseCases;
    private UserCategoriesService userCategoriesService;
    private CategoryService categoryService;

    public List<Category> findUserLikedCategories(Long userId) {
        userUseCases.findById(userId);
        return categoryService.findByIdIn(userCategoriesService
                .findByUserId(userId).stream().map(UserCategories::getCategoryId).toList());
    }

    public void likeCategories(Long userId, List<Long> categoriesIds) {
        userUseCases.findById(userId);
        categoriesIds.forEach(categoryId -> categoryService.likeCategory(userId, categoryId));
    }

    public List<Category> findAll() {
        return categoryService.findAll();
    }

    public List<Category> findByVideoId(Long videoId) {
        return categoryService.findByVideoId(videoId);
    }

}
