package com.tech.challenge.persistence;

import com.tech.challenge.model.Video;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;

public interface VideoPersistence {

    Mono<Video> save(Video video, MultipartFile videoFile) throws IOException;

    void delete(Video video) throws IOException;

    Mono<Video> findById(Long id);

    Flux<Video> findByIdIn(List<Long> ids);

    Flux<Video> findByVideoNameLike(String name);

    Flux<Video> findRecommendedVideosByUserId(Long userId);
}
