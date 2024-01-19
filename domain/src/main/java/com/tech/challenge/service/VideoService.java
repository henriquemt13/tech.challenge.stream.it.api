package com.tech.challenge.service;

import com.tech.challenge.dto.CreateVideoDTO;
import com.tech.challenge.dto.SearchResultDTO;
import com.tech.challenge.dto.SearchVideoDTO;
import com.tech.challenge.model.Video;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface VideoService {

    Video upload(CreateVideoDTO createVideoDTO) throws IOException;

    void delete(Long id, Long userId);

    Optional<Video> findById(Long id);

    SearchResultDTO<Video> findByIdIn(List<Long> ids, SearchVideoDTO searchVideoDTO);

    List<Video> findByIdIn(List<Long> ids);

    Optional<Video> findByVideoPath(String videoPath);

    List<Video> findRecommendedVideosByUserId(Long userId);

    SearchResultDTO<Video> findAll(SearchVideoDTO searchVideoDTO);

    Long findTotalVideos();
}
