package com.tech.challenge.service;

import com.tech.challenge.dto.CreateVideoDTO;
import com.tech.challenge.exception.BadRequestException;
import com.tech.challenge.exception.NotFoundException;
import com.tech.challenge.fixture.VideoFixture;
import com.tech.challenge.model.Video;
import com.tech.challenge.persistence.VideoPersistence;
import com.tech.challenge.service.impl.VideoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VideoServiceTest {

    @InjectMocks
    private VideoServiceImpl service;

    @Mock
    private VideoPersistence persistence;

    @Mock
    private VideoCategoriesService videoCategoriesService;

    @Test
    void uploadShouldRunAsExpected() throws IOException {
        var uploadResult = Mono.just(VideoFixture.newVideo());
        when(persistence.save(any(), any())).thenReturn(uploadResult);

        var result = service.upload(new CreateVideoDTO());

        verify(persistence, times(1)).save(any(), any());
        verify(videoCategoriesService, times(1)).save(anyLong(), any());
        assertEquals(result, uploadResult);
    }

    @Test
    void deleteShouldRunAsExpected() throws IOException {
        when(service.findById(anyLong())).thenReturn(Mono.just(VideoFixture.newVideo()));
        doNothing().when(persistence).delete(any());

        assertDoesNotThrow(() -> service.delete(1L, 1L));
    }

    @Test
    void deleteShouldThrowBadRequestException() {
        when(persistence.findById(anyLong())).thenReturn(Mono.just(VideoFixture.newVideo()));
        Publisher<Video> existentVideo = service.findById(anyLong()).then(Mono.just(VideoFixture.newVideo()));

        StepVerifier.create(existentVideo).consumeNextWith(c ->
                assertThrows(BadRequestException.class, () -> service.delete(1L, 1L)));
    }

    @Test
    void deleteShouldThrowNotFoundException() {
        when(persistence.findById(anyLong())).thenReturn(Mono.empty());
        Publisher<Video> existentVideo = service.findById(anyLong()).then(Mono.empty());

        StepVerifier.create(existentVideo).consumeNextWith(c ->
                assertThrows(NotFoundException.class, () -> service.delete(1L, 1L)));
    }


    @Test
    void findById() {
        when(persistence.findById(anyLong())).thenReturn(Mono.empty());
        Publisher<Video> existentVideo = service.findById(anyLong()).then(Mono.just(VideoFixture.newVideo()));

        StepVerifier.create(existentVideo).consumeNextWith(c ->
                assertEquals(c, existentVideo));
    }

    @Test
    void findByIdIn() {
        when(persistence.findByIdIn(any())).thenReturn(Flux.just(VideoFixture.newVideo()));
        Publisher<Video> existentVideos = service.findByIdIn(any()).thenMany(Flux.just(VideoFixture.newVideo()));

        StepVerifier.create(existentVideos).consumeNextWith(c ->
                assertEquals(c, existentVideos));
    }

    @Test
    void findByVideoNameLike() {
        when(persistence.findByVideoNameLike(anyString())).thenReturn(Flux.just(VideoFixture.newVideo()));
        Publisher<Video> existentVideos = service.findByVideoNameLike(anyString()).thenMany(Flux.just(VideoFixture.newVideo()));

        StepVerifier.create(existentVideos).consumeNextWith(c ->
                assertEquals(c, existentVideos));
    }

    @Test
    void findRecommendedVideosByUserId() {
        when(persistence.findRecommendedVideosByUserId(anyLong())).thenReturn(Flux.just(VideoFixture.newVideo()));
        Publisher<Video> existentVideos = service.findRecommendedVideosByUserId(anyLong()).thenMany(Flux.just(VideoFixture.newVideo()));

        StepVerifier.create(existentVideos).consumeNextWith(c ->
                assertEquals(c, existentVideos));
    }
}