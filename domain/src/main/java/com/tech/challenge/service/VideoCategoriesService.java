package com.tech.challenge.service;

import com.tech.challenge.model.VideoCategories;
import java.util.List;

public interface VideoCategoriesService {

    void save(Long videoId, List<Long> categoriesId);

    List<VideoCategories> findByVideoId(Long videoId);

    List<VideoCategories> findByCategoryIdIn(List<Long> categoryIds);
}
