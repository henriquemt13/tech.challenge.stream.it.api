package com.tech.challenge.adapter;

import com.tech.challenge.specification.SearchVideoSpecification;
import com.tech.challenge.dto.SearchResultDTO;
import com.tech.challenge.dto.SearchVideoDTO;
import com.tech.challenge.mapper.VideoEntityMapper;
import com.tech.challenge.model.Video;
import com.tech.challenge.persistence.VideoPersistence;
import com.tech.challenge.repository.VideoRepository;
import com.tech.challenge.storage.VideoStorage;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class VideoAdapter implements VideoPersistence {

    private final VideoRepository repository;
    private final VideoEntityMapper mapper;
    private final VideoStorage storage;

    @Override
    public Video save(Video video, MultipartFile videoFile) throws IOException {
        var videoPath = storage.uploadVideo(video, videoFile);
        video.setVideoPath(videoPath);
        return mapper.toDomain(repository.save(mapper.toEntity(video)));
    }

    @Override
    public void delete(Video video) throws IOException {
        storage.deleteVideo(video.getVideoPath());
        repository.delete(mapper.toEntity(video));
    }

    @Override
    public Optional<Video> findById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public SearchResultDTO<Video> findByIdIn(List<Long> ids, SearchVideoDTO searchVideoDTO) {
        return mapper.toDomain(repository.findByIdIn(ids, PageRequest.of(searchVideoDTO.getPage(),
                searchVideoDTO.getSize(), Sort.by("uploadDate").descending())));
    }

    public List<Video> findByIdIn(List<Long> ids) {
        return mapper.toDomain(repository.findByIdIn(ids));
    }

    @Override
    public List<Video> findRecommendedVideosByUserId(Long userId) {
        return mapper.toDomain(repository.findRecommendedVideosByUserId(userId));
    }

    @Override
    public Optional<Video> findByVideoPath(String videoPath) {
        return repository.findByVideoPath(videoPath).map(mapper::toDomain);
    }

    @Override
    public SearchResultDTO<Video> findAll(SearchVideoDTO searchVideoDTO) {
        return mapper.toDomain(repository.findAll(SearchVideoSpecification.search(searchVideoDTO),
                PageRequest.of(searchVideoDTO.getPage(), searchVideoDTO.getSize(), Sort.by("uploadDate")
                        .descending())));
    }

    @Override
    public Long totalVideos() {
        return repository.count();
    }
}
