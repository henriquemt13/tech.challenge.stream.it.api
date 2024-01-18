package com.tech.challenge.controller.v1;

import com.tech.challenge.config.TestConfig;
import com.tech.challenge.fixture.CategoryFixture;
import com.tech.challenge.mapper.CategoryMapper;
import com.tech.challenge.usecase.CategoryUseCases;
import com.tech.challenge.utils.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
@Import({CategoryController.class})
@ContextConfiguration(classes = TestConfig.class)
class CategoryControllerTest {

    private static final String PATH = "/category";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CategoryMapper mapper;

    @MockBean
    private CategoryUseCases categoryUseCases;


    @Test
    void findAllShouldRunAsExpected() throws Exception {

        when(categoryUseCases.findAll()).thenReturn(List.of(CategoryFixture.newCategory()));

        var result = mvc.perform(
                get(PATH)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk()).andReturn();

        verify(categoryUseCases, times(1)).findAll();
        assertEquals(FileUtils.readFileFromClassLoader("json/expected/category-find-all-expected-result.json"),
                result.getResponse().getContentAsString());

    }

    @Test
    void findByVideoId() {
    }

    @Test
    void findLikedCategories() {
    }

    @Test
    void likeCategories() {
    }
}