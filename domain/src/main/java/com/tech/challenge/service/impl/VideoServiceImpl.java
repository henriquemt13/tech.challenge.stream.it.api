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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {

    private VideoPersistence persistence;
    private VideoCategoriesService videoCategoriesService;

    @Override
    public Mono<Video> upload(CreateVideoDTO createVideoDTO) throws IOException {
        var video = persistence.save(new Video(createVideoDTO), createVideoDTO.getVideo());
        video.subscribe(v -> videoCategoriesService.save(v.getId(), createVideoDTO.getCategoryIds()));
        return video;
    }

    @Override
    public void delete(Long id, Long userId) {
        var existentVideo = findById(id);
        validateDelete(existentVideo, id);
        existentVideo.subscribe(video -> {
            try {
                deleteVideo(video, userId);
            } catch (IOException e) {
                throw new BadRequestException(String
                        .format("There was an error while trying to delete Video ID %d", id));
            }
        });
    }

    private void validateDelete(Mono<Video> existentVideo, Long id) {
        existentVideo.hasElement().subscribe(ev -> {
            if (Boolean.FALSE.equals(ev)) {
                throw new NotFoundException(String.format("Video ID %d not found", id));
            }
        });
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
    public Mono<Video> findById(Long id) {
        return persistence.findById(id);
    }

    @Override
    public Flux<Video> findByIdIn(List<Long> ids) {
        return persistence.findByIdIn(ids);
    }

    @Override
    public Flux<Video> findByVideoNameLike(String name) {
        return persistence.findByVideoNameLike(name);
    }

    @Override
    public Flux<Video> findRecommendedVideosByUserId(Long userId) {
        return persistence.findRecommendedVideosByUserId(userId);
    }
}
