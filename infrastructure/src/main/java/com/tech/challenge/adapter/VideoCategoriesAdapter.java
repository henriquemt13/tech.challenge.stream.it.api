package com.tech.challenge.adapter;

import com.tech.challenge.mapper.VideoCategoriesEntityMapper;
import com.tech.challenge.model.VideoCategories;
import com.tech.challenge.persistence.VideoCategoriesPersistence;
import com.tech.challenge.repository.VideoCategoriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VideoCategoriesAdapter implements VideoCategoriesPersistence {

    private final VideoCategoriesRepository repository;
    private final VideoCategoriesEntityMapper mapper;

    @Override
    public void save(VideoCategories videoCategories) {
        repository.save(mapper.toEntity(videoCategories));
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
