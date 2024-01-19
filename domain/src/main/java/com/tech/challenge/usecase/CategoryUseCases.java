package com.tech.challenge.usecase;

import com.tech.challenge.model.Category;
import com.tech.challenge.model.UserCategories;
import com.tech.challenge.model.VideoCategories;
import com.tech.challenge.service.CategoryService;
import com.tech.challenge.service.UserCategoriesService;
import com.tech.challenge.service.VideoCategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CategoryUseCases {

    private final UserUseCases userUseCases;
    private final UserCategoriesService userCategoriesService;
    private final VideoCategoriesService videoCategoriesService;
    private final CategoryService categoryService;

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
        var categoriesIds = videoCategoriesService.findByVideoId(videoId);
        return categoryService.findByIdIn(categoriesIds.stream().map(VideoCategories::getCategoryId).toList());
    }

    public List<Long> findVideosIdsByCategoryId(Long categoryId) {
        var videocategories = videoCategoriesService.findByCategoryIdIn(List.of(categoryId));

        return videocategories.stream().map(VideoCategories::getVideoId).toList();
    }

}
