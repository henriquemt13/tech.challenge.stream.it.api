package com.tech.challenge.service;

import com.tech.challenge.exception.BadRequestException;
import com.tech.challenge.fixture.LikeFixture;
import com.tech.challenge.model.LikeOptionEnum;
import com.tech.challenge.persistence.LikePersistence;
import com.tech.challenge.service.impl.LikeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LikeServiceTest {

    @InjectMocks
    private LikeServiceImpl service;

    @Mock
    private LikePersistence persistence;

    @Test
    void likeVideoShouldRunAsExpected() {

        when(service.findByUserIdAndVideoId(anyLong(), anyLong())).thenReturn(Optional.empty());

        doNothing().when(persistence).likeVideo(anyLong(), anyLong());

        service.likeVideo(1L, 1L);

        verify(persistence, times(1))
                .likeVideo(anyLong(), anyLong());
    }

    @Test
    void likeVideoShouldThrowBadRequestException() {

        when(service.findByUserIdAndVideoId(anyLong(), anyLong()))
                .thenReturn(Optional.of(LikeFixture.newLike()));
        assertThrows(BadRequestException.class, () -> service.likeVideo(1L, 1L));
    }

    @Test
    void likeVideoShouldRunAndDeleteExistentDislike() {

        when(service.findByUserIdAndVideoId(anyLong(), anyLong()))
                .thenReturn(Optional.of(LikeFixture.newDislike()));
        doNothing().when(persistence).likeVideo(anyLong(), anyLong());

        service.likeVideo(1L, 1L);

        verify(persistence, times(1))
                .likeVideo(anyLong(), anyLong());
    }

    @Test
    void dislikeVideoShouldRunAsExpected() {

        when(service.findByUserIdAndVideoId(anyLong(), anyLong())).thenReturn(Optional.empty());

        doNothing().when(persistence).dislikeVideo(anyLong(), anyLong());

        service.dislikeVideo(1L, 1L);

        verify(persistence, times(1))
                .dislikeVideo(anyLong(), anyLong());
    }

    @Test
    void dislikeVideoShouldThrowBadRequestException() {

        when(service.findByUserIdAndVideoId(anyLong(), anyLong()))
                .thenReturn(Optional.of(LikeFixture.newDislike()));
        assertThrows(BadRequestException.class, () -> service.dislikeVideo(1L, 1L));
    }

    @Test
    void dislikeVideoShouldRunAndDeleteExistentDislike() {

        when(service.findByUserIdAndVideoId(anyLong(), anyLong()))
                .thenReturn(Optional.of(LikeFixture.newLike()));
        doNothing().when(persistence).dislikeVideo(anyLong(), anyLong());

        service.dislikeVideo(1L, 1L);

        verify(persistence, times(1))
                .dislikeVideo(anyLong(), anyLong());
    }

    @Test
    void findByUserIdShouldRunAsExpected() {

        when(persistence.findByUserId(anyLong())).thenReturn(List.of(LikeFixture.newLike()));

        var result = service.findByUserId(1L);

        assertEquals(result, List.of(LikeFixture.newLike()));
        verify(persistence, times(1)).findByUserId(anyLong());
    }

    @Test
    void findByUserIdAndLikeOptionShouldRunAsExpected() {
        when(persistence.findByUserIdAndLikeOption(anyLong(), any())).thenReturn(List.of(LikeFixture.newLike()));

        var result = service.findByUserIdAndLikeOption(1L, LikeOptionEnum.LIKE);

        assertEquals(result, List.of(LikeFixture.newLike()));
        verify(persistence, times(1)).findByUserIdAndLikeOption(anyLong(), any());
    }

    @Test
    void findTotalInteractionsShouldRunAsExpected() {
        when(persistence.totalInteractions()).thenReturn(1L);

        var result = service.findTotalInteractions();

        assertEquals(1L, result);
        verify(persistence, times(1)).totalInteractions();
    }

    @Test
    void findTotalLikes() {
        when(persistence.totalLikes()).thenReturn(1L);

        var result = service.findTotalLikes();

        assertEquals(1L, result);
        verify(persistence, times(1)).totalLikes();
    }

}