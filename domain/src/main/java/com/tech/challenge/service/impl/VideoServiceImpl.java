package com.tech.challenge.service.impl;

import com.tech.challenge.dto.CreateVideoDTO;
import com.tech.challenge.exception.BadRequestException;
import com.tech.challenge.exception.NotFoundException;
import com.tech.challenge.model.Video;
import com.tech.challenge.persistence.VideoPersistence;
import com.tech.challenge.service.VideoCategoriesService;
import com.tech.challenge.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final VideoPersistence persistence;
    private final VideoCategoriesService videoCategoriesService;

    @Override
    public Video upload(CreateVideoDTO createVideoDTO) throws IOException {
        var video = persistence.save(new Video(createVideoDTO), createVideoDTO.getVideo());
        videoCategoriesService.save(video.getId(), createVideoDTO.getCategoryIds());
        return video;
    }
    @Override
    public void delete(Long id, Long userId) {
        var existentVideo = findById(id);
        if (existentVideo.isEmpty()) {
            throw new NotFoundException(String.format("Video ID %d not found", id));
        }
        try {
                deleteVideo(existentVideo.get(), userId);
            } catch (IOException e) {
                throw new BadRequestException(String
                        .format("There was an error while trying to delete Video ID %d", id));
            }
    }

    private void deleteVideo(Video video, Long userId) throws IOException {
        if (Objects.equals(video.getUploaderUserId(), userId)) {
            persistence.delete(video);
        } else {
            throw new BadRequestException(String
                    .format("User ID %d is not the Video ID %d owner", userId, video.getId()));
        }
    }

    @Override
    public Optional<Video> findById(Long id) {
        return persistence.findById(id);
    }

    @Override
    public List<Video> findByIdIn(List<Long> ids) {
        return persistence.findByIdIn(ids);
    }

    @Override
    public List<Video> findByVideoNameLike(String name) {
        return persistence.findByVideoNameLike(name);
    }

    @Override
    public Optional<Video> findByVideoPath(String videoPath) {
        return persistence.findByVideoPath(videoPath);
    }

    @Override
    public List<Video> findRecommendedVideosByUserId(Long userId) {
        return persistence.findRecommendedVideosByUserId(userId);
    }

    @Override
    public List<Video> findAll() {
        return persistence.findAll();
    }
}
