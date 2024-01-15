package com.tech.challenge.service.impl;

import com.tech.challenge.exception.BadRequestException;
import com.tech.challenge.model.VideoCategories;
import com.tech.challenge.persistence.VideoCategoriesPersistence;
import com.tech.challenge.service.VideoCategoriesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VideoCategoriesServiceImpl implements VideoCategoriesService {

    private VideoCategoriesPersistence persistence;

    @Override
    public void save(Long videoId, List<Long> categoriesId) {
        if (!findByVideoId(videoId).isEmpty()) {
            throw new BadRequestException(String.format("Categories already added to Video ID %d", videoId));
        }
        persistence.save(videoId, categoriesId);
    }

    @Override
    public List<VideoCategories> findByVideoId(Long videoId) {
        return persistence.findByVideoId(videoId);
    }

    @Override
    public List<VideoCategories> findByCategoryIdIn(List<Long> categoryIds) {
        return persistence.findByCategoryIdIn(categoryIds);
    }
}
