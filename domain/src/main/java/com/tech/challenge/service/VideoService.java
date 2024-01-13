package com.tech.challenge.service;

import com.tech.challenge.dto.CreateVideoDTO;
import com.tech.challenge.model.Video;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface VideoService {

    Mono<Video> upload(CreateVideoDTO createVideoDTO) throws IOException;

    void delete(Long id, Long userId);

    Mono<Video> findById(Long id);

    Flux<Video> findByIdIn(List<Long> ids);

    Flux<Video> findByVideoNameLike(String name);

    Flux<Video> findRecommendedVideosByUserId(Long userId);

}
