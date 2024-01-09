package com.tech.challenge.adapter;

import com.tech.challenge.model.Video;
import com.tech.challenge.persistence.VideoPersistence;
import com.tech.challenge.repository.VideoRepository;

import java.util.List;
import java.util.Optional;

public class VideoAdapter implements VideoPersistence {

    private VideoRepository repository;

    @Override
    public Video save(Video video) {
        return null;
    }

    @Override
    public Video update(Video video) {
        return null;
    }

    @Override
    public void deleteVideo(Long id) {

    }

    @Override
    public Optional<Video> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Video> findByIdIn(List<Long> ids) {
        return null;
    }

    @Override
    public List<Video> findByVideoNameLike(String name) {
        return null;
    }

    @Override
    public List<Video> findRecommendedVideosByUserId(Long userId) {
        return null;
    }
}
