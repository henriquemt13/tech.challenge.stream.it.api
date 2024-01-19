package com.tech.challenge.usecase;

import com.tech.challenge.dto.CreateVideoDTO;
import com.tech.challenge.exception.NotFoundException;
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
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Optional;

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

    @Test
    void uploadVideoShouldRunAsExpected() throws IOException {
        when(videoService.upload(any())).thenReturn(VideoFixture.newVideo());

        var result = useCases.uploadVideo(new CreateVideoDTO());

        assertEquals(result, VideoFixture.newVideo());
    }

    @Test
    void deleteVideoShouldRunAsExpected() {
        doNothing().when(videoService).delete(anyLong(), anyLong());

        assertDoesNotThrow(() -> useCases.deleteVideo(1L, 1L));
    }

    @Test
    void findByVideoNameLikeShouldRunAsExpected() {
        when(videoService.findByVideoNameLike(anyString())).thenReturn(List.of(VideoFixture.newVideo()));

        var result = useCases.findByVideoNameLike("test");

        assertEquals(result, List.of(VideoFixture.newVideo()));
    }

    @Test
    void likeVideoShouldRunAsExpected() {
        doNothing().when(likeService).likeVideo(anyLong(), anyLong());

        assertDoesNotThrow(() -> useCases.likeVideo(1L, 1L));
    }

    @Test
    void dislikeVideoShouldRunAsExpected() {
        doNothing().when(likeService).dislikeVideo(anyLong(), anyLong());

        assertDoesNotThrow(() -> useCases.dislikeVideo(1L, 1L));
    }

    @Test
    void findDetailsByIdShouldRunAsExpected() {
        when(videoService.findById(anyLong())).thenReturn(Optional.of(VideoFixture.newVideo()));

        var video = useCases.findDetailsById(1L);

        assertEquals(video, VideoFixture.newVideo());
    }

    @Test
    void findUserInteractedVideosShouldRunAsExpected() {
        when(likeService.findByUserIdAndLikeOption(anyLong(), any())).thenReturn(List.of(LikeFixture.newLike()));
        when(videoService.findByIdIn(any())).thenReturn(List.of(VideoFixture.newVideo()));

        var result = useCases.findUserInteractedVideos(1L, LikeOptionEnum.LIKE);

        assertEquals(result, List.of(VideoFixture.newVideo()));
    }

    @Test
    void findLastViewedVideosShouldRunAsExpected() {
        when(viewingHistoryService.findByUserId(anyLong())).thenReturn(List.of(ViewingHistoryFixture.newViewHistory()));
        when(videoService.findByIdIn(any())).thenReturn(List.of(VideoFixture.newVideo()));

        var result = useCases.findLastViewedVideos(1L);

        assertEquals(result, List.of(VideoFixture.newVideo()));
    }

    @Test
    void findRecommendedVideosShouldRunAsExpected() {
        when(videoService.findRecommendedVideosByUserId(any())).thenReturn(List.of(VideoFixture.newVideo()));

        var result = useCases.findRecommendedVideos(1L);

        assertEquals(result, List.of(VideoFixture.newVideo()));
    }


    @Test
    void streamVideoShouldReturnResource() throws MalformedURLException {
        String videoPath = "test";
        Long userId = 1L;
        byte[] videoContent = "test".getBytes();
        Resource mockResource = new ByteArrayResource(videoContent);

        when(videoService.findByVideoPath(videoPath)).thenReturn(Optional.of(VideoFixture.newVideo()));
        when(storage.streamVideo(videoPath)).thenReturn(Mono.just(mockResource));

        Mono<Resource> result = useCases.streamVideo(videoPath, userId);

        assertDoesNotThrow(() -> result.block());
        assertEquals(mockResource, result.block());

        verify(viewingHistoryService, times(1)).addView(anyLong(), anyLong());
        verify(videoService, times(1)).findByVideoPath(videoPath);
        verify(storage, times(1)).streamVideo(videoPath);
    }

    @Test
    void streamVideoShouldTHrowNotFoundException() {
        String videoPath = "test";
        when(videoService.findByVideoPath(any())).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> useCases.streamVideo(videoPath, 1L));
        verify(videoService, times(1)).findByVideoPath(videoPath);
    }

}