package com.tech.challenge.controller.v1;

import com.tech.challenge.config.TestConfig;
import com.tech.challenge.fixture.UserFixture;
import com.tech.challenge.mapper.UserMapper;
import com.tech.challenge.usecase.UserUseCases;
import com.tech.challenge.utils.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@Import({UserController.class})
@ContextConfiguration(classes = TestConfig.class)
class UserControllerTest {


    private static final String PATH = "/user";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserUseCases userUseCases;

    @MockBean
    private UserMapper mapper;

    @BeforeEach
    void setupMockMvc() {
        this.mvc = MockMvcBuilders
                .standaloneSetup(new UserController(userUseCases, mapper))
                .addFilter(((request, response, chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request, response);
                })).build();
    }

    @Test
    void findByIdShouldRunAsExpected() throws Exception {
        long id = 1L;
        when(userUseCases.findById(anyLong())).thenReturn(UserFixture.newUser());

        var result = mvc.perform(
                get(PATH + "/" + id)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk()).andReturn();

        verify(userUseCases, times(1)).findById(anyLong());
    }

    @Test
    void saveShouldRunAsExpected() throws Exception {
        when(userUseCases.saveUser(any())).thenReturn(UserFixture.newUser());

        var result = mvc.perform(
                post(PATH)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(FileUtils.readBytesFromClassLoader("json/request/json-user-create-request.json"))
        ).andExpect(status().isOk()).andReturn();

        verify(userUseCases, times(1)).saveUser(any());
    }
}