package com.tech.challenge.persistence;

import com.tech.challenge.model.VideoCategories;

import java.util.List;

public interface VideoCategoriesPersistence {

    void save(Long videoId, List<Long> categoriesId);

    List<VideoCategories> findByVideoId(Long videoId);

    List<VideoCategories> findByCategoryIdIn(List<Long> categoryIds);
}
