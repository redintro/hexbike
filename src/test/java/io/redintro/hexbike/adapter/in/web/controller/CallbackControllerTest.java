package io.redintro.hexbike.adapter.in.web.controller;

import io.redintro.hexbike.service.HexBikeUserDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CallbackController.class)
class CallbackControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private HexBikeUserDetailsService userDetailsService;

    @Test
    public void shouldFindAll() throws Exception {
        MockHttpServletResponse response = mvc.perform(
                MockMvcRequestBuilders.get("/api/callbacks")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus(), is(equalTo(HttpStatus.OK.value())));
    }
}