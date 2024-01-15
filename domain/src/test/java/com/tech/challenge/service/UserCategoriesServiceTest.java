package com.tech.challenge.service;

import com.tech.challenge.exception.BadRequestException;
import com.tech.challenge.fixture.UserCategoriesFixture;
import com.tech.challenge.model.LikeOptionEnum;
import com.tech.challenge.persistence.UserCategoriesPersistence;
import com.tech.challenge.service.impl.UserCategoriesServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserCategoriesServiceTest {

    @InjectMocks
    private UserCategoriesServiceImpl service;

    @Mock
    private UserCategoriesPersistence persistence;

    @Test
    void saveShouldRunAsExpected() {

        when(persistence.save(any())).thenReturn(UserCategoriesFixture.newUserCategoriesFixture());

        var result = service.save(1L, 1L);

        assertEquals(result, UserCategoriesFixture.newUserCategoriesFixture());
        verify(persistence, times(1)).save(any());
    }

    @Test
    void saveShouldThrowBadRequestException() {

        when(service.findByUserId(anyLong())).thenReturn(List.of(UserCategoriesFixture.newUserCategoriesFixture()));

        assertThrows(BadRequestException.class, () -> service.save(1L, 1L));
    }

    @Test
    void findByUserIdShouldRunAsExpected() {

        when(persistence.findByUserId(anyLong())).thenReturn(List.of(UserCategoriesFixture.newUserCategoriesFixture()));

        var result = service.findByUserId(1L);

        assertEquals(result, List.of(UserCategoriesFixture.newUserCategoriesFixture()));
        verify(persistence, times(1)).findByUserId(anyLong());

    }

    @Test
    void findByUserIdAndLikeOptionShouldRunAsExpected() {

        when(persistence.findByUserIdAndLikeOption(anyLong(), any()))
                .thenReturn(List.of(UserCategoriesFixture.newUserCategoriesFixture()));

        var result = service.findByUserIdAndLikeOption(1L, LikeOptionEnum.LIKE);

        assertEquals(result, List.of(UserCategoriesFixture.newUserCategoriesFixture()));
        verify(persistence, times(1)).findByUserIdAndLikeOption(anyLong(), any());
    }
}