package com.tech.challenge.usecase;

import com.tech.challenge.dto.CreateVideoDTO;
import com.tech.challenge.fixture.LikeFixture;
import com.tech.challenge.fixture.VideoFixture;
import com.tech.challenge.fixture.ViewingHistoryFixture;
import com.tech.challenge.model.Like;
import com.tech.challenge.model.LikeOptionEnum;
import com.tech.challenge.model.Video;
import com.tech.challenge.model.ViewingHistory;
import com.tech.challenge.service.LikeService;
import com.tech.challenge.service.VideoService;
import com.tech.challenge.service.ViewingHistoryService;
import com.tech.challenge.storage.VideoStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reactivestreams.Publisher;
import org.springframework.core.io.Resource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VideoUseCasesTest {

    @InjectMocks
    private VideoUseCases useCases;

    @Mock
    private LikeService likeService;

    @Mock
    private VideoService videoService;

    @Mock
    private ViewingHistoryService viewingHistoryService;

    @Mock
    private VideoStorage storage;
//
//    @Test
//    void uploadVideoShouldRunAsExpected() throws IOException {
//        var uploadResult = Mono.just(VideoFixture.newVideo());
//        when(videoService.upload(any())).thenReturn(uploadResult);
//
//        var result = useCases.uploadVideo(new CreateVideoDTO());
//
//        assertEquals(result, uploadResult);
//    }
//
//    @Test
//    void streamVideoShouldRunAsExpected() throws MalformedURLException {
//        when(storage.streamVideo(anyString())).thenReturn(Mono.empty());
//        Publisher<Video> videoPublisher = useCases.streamVideo(anyString()).then(Mono.just(VideoFixture.newVideo()));
//
//        StepVerifier.create(videoPublisher).consumeNextWith(c ->
//                assertEquals(c, videoPublisher));
//    }
//
//    @Test
//    void deleteVideoShouldRunAsExpected() {
//        doNothing().when(videoService).delete(anyLong(), anyLong());
//
//        assertDoesNotThrow(() -> useCases.deleteVideo(1L, 1L));
//    }
//
//    @Test
//    void findByVideoNameLikeShouldRunAsExpected() {
//        when(videoService.findByVideoNameLike(anyString())).thenReturn(Flux.empty());
//        Publisher<Video> videoPublisher = useCases.findByVideoNameLike(anyString()).thenMany(Flux.just(VideoFixture.newVideo()));
//
//        StepVerifier.create(videoPublisher).consumeNextWith(c ->
//                assertEquals(c, videoPublisher));
//    }
//
//    @Test
//    void likeVideoShouldRunAsExpected() {
//        doNothing().when(likeService).likeVideo(anyLong(), anyLong());
//
//        assertDoesNotThrow(() -> useCases.likeVideo(1L, 1L));
//    }
//
//    @Test
//    void dislikeVideoShouldRunAsExpected() {
//        doNothing().when(likeService).dislikeVideo(anyLong(), anyLong());
//
//        assertDoesNotThrow(() -> useCases.dislikeVideo(1L, 1L));
//    }
//
//    @Test
//    void findDetailsByIdShouldRunAsExpected() {
//        when(videoService.findById(anyLong())).thenReturn(Mono.just(VideoFixture.newVideo()));
//        Publisher<Video> videoPublisher = useCases.findDetailsById(anyLong()).then(Mono.just(VideoFixture.newVideo()));
//
//        StepVerifier.create(videoPublisher).consumeNextWith(c ->
//                assertEquals(c, videoPublisher));
//    }
//
//    @Test
//    void findUserInteractedVideosShouldRunAsExpected() {
//        when(likeService.findByUserIdAndLikeOption(anyLong(), any())).thenReturn(List.of(LikeFixture.newLike()));
//        when(videoService.findByIdIn(any())).thenReturn(Flux.just(VideoFixture.newVideo()));
//        Publisher<Video> videoPublisher = useCases.findUserInteractedVideos(anyLong(), any()).thenMany(Flux.just(VideoFixture.newVideo()));
//
//        StepVerifier.create(videoPublisher).consumeNextWith(c ->
//                assertEquals(c, videoPublisher));
//    }
//
//    @Test
//    void findLastViewedVideosShouldRunAsExpected() {
//        when(videoService.findByIdIn(any())).thenReturn(Flux.just(VideoFixture.newVideo()));
//        Publisher<Video> videoPublisher = useCases.findLastViewedVideos(anyLong()).thenMany(Flux.just(VideoFixture.newVideo()));
//
//        StepVerifier.create(videoPublisher).consumeNextWith(c ->
//                assertEquals(c, videoPublisher));
//    }
//
//    @Test
//    void findRecommendedVideosShouldRunAsExpected() {
//        when(videoService.findRecommendedVideosByUserId(any())).thenReturn(Flux.just(VideoFixture.newVideo()));
//        Publisher<Video> videoPublisher = useCases.findRecommendedVideos(anyLong()).then(Mono.just(VideoFixture.newVideo()));
//
//        StepVerifier.create(videoPublisher).consumeNextWith(c ->
//                assertEquals(c, videoPublisher));
//    }

}