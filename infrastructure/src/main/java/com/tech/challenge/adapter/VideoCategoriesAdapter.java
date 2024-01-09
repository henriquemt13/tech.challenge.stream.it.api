package com.tech.challenge.adapter;

import com.tech.challenge.model.VideoCategories;
import com.tech.challenge.persistence.VideoCategoriesPersistence;
import com.tech.challenge.repository.VideoCategoriesRepository;

import java.util.List;

public class VideoCategoriesAdapter implements VideoCategoriesPersistence {

    private VideoCategoriesRepository repository;

    @Override
    public void save(Long videoId, List<Long> categoriesId) {

    }

    @Override
    public List<VideoCategories> findByVideoId(Long videoId) {
        return null;
    }

    @Override
    public List<VideoCategories> findByCategoryIdIn(List<Long> categoryIds) {
        return null;
    }
}
