package com.tech.challenge.service;

import com.tech.challenge.model.Category;

import java.util.List;

public interface CategoryService {

    void likeCategory(Long userId, Long categoryId);

    void dislikeCategory(Long userId, Long categoryId);

    List<Category> findAll();

    Category findById(Long id);

}
