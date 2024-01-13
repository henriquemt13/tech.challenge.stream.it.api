package com.tech.challenge.adapter;

import com.tech.challenge.mapper.VideoCategoriesEntityMapper;
import com.tech.challenge.model.VideoCategories;
import com.tech.challenge.persistence.VideoCategoriesPersistence;
import com.tech.challenge.repository.VideoCategoriesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class VideoCategoriesAdapter implements VideoCategoriesPersistence {

    private VideoCategoriesRepository repository;
    private VideoCategoriesEntityMapper mapper;

    @Override
    public void save(Long videoId, List<Long> categoriesId) {
    }

    @Override
    public List<VideoCategories> findByVideoId(Long videoId) {
        return mapper.toDomain(repository.findByVideoId(videoId));
    }

    @Override
    public List<VideoCategories> findByCategoryIdIn(List<Long> categoryIds) {
        return mapper.toDomain(repository.findByCategoryIdIn(categoryIds));
    }
}
