package com.tech.challenge.adapter;

import com.tech.challenge.mapper.VideoEntityMapper;
import com.tech.challenge.model.Video;
import com.tech.challenge.persistence.VideoPersistence;
import com.tech.challenge.repository.VideoRepository;
import com.tech.challenge.storage.VideoStorage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

@Component
@AllArgsConstructor
public class VideoAdapter implements VideoPersistence {

    private VideoRepository repository;
    private VideoEntityMapper mapper;
    private VideoStorage storage;

    @Override
    public Mono<Video> save(Video video, MultipartFile videoFile) throws IOException {
        var videoPath = storage.uploadVideo(video.getUploaderUserId(), videoFile);
        videoPath.subscribe(video::setVideoPath);
        return mapper.toDomain(repository.save(mapper.toEntity(video)));
    }

    @Override
    public void delete(Video video) throws IOException {
        storage.deleteVideo(video.getVideoPath());
        repository.delete(mapper.toEntity(video));
    }

    @Override
    public Mono<Video> findById(Long id) {
        return mapper.toDomain(repository.findById(id));
    }

    @Override
    public Flux<Video> findByIdIn(List<Long> ids) {
        return mapper.toDomain(repository.findByIdIn(ids));
    }

    @Override
    public Flux<Video> findByVideoNameLike(String name) {
        return mapper.toDomain(repository.findByVideoNameLike(name));
    }

    @Override
    public Flux<Video> findRecommendedVideosByUserId(Long userId) {
        return mapper.toDomain(repository.findRecommendedVideosByUserId(userId));
    }
}
