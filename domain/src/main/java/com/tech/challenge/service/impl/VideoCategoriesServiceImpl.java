package com.tech.challenge.service.impl;

import com.tech.challenge.model.VideoCategories;
import com.tech.challenge.persistence.VideoCategoriesPersistence;
import com.tech.challenge.service.VideoCategoriesService;

import java.util.List;

public class VideoCategoriesServiceImpl implements VideoCategoriesService {

    private VideoCategoriesPersistence persistence;

    @Override
    public void save(Long videoId, List<Long> categoriesId) {
        persistence.save(videoId, categoriesId);
    }

    @Override
    public List<VideoCategories> findByVideoId(Long videoId) {
        return persistence.findByVideoId(videoId);
    }

    @Override
    public List<VideoCategories> findByCategoryIdIn(List<Long> categoryIds) {
        return findByCategoryIdIn(categoryIds);
    }
}
