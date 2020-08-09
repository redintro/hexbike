package io.redintro.hexbike.adapter.in.web.controller;

import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.domain.Owner;
import io.redintro.hexbike.port.in.ShowBikePort;
import io.redintro.hexbike.service.AuthenticationService;
import io.redintro.hexbike.service.UserDetailsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@AutoConfigureJsonTesters
@WebMvcTest(BikeController.class)
class BikeControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ShowBikePort showBikePort;

    @MockBean
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JacksonTester<List<Bike>> bikeListJacksonTester;

    @Autowired
    private JacksonTester<Bike> bikeJacksonTester;

    private String jwtToken;

    private Bike bike;

    @BeforeEach
    public void setUp() {
        jwtToken = AuthenticationService.getToken("admin");

        when(userDetailsService.loadUserByUsername(any(String.class)))
                .thenReturn(new org.springframework.security.core.
                        userdetails.User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG",
                        true, true, true, true,
                        AuthorityUtils.createAuthorityList("ADMIN")));

        bike = new Bike(1L, "Cinelli", "Vigorelli", "White", 2017,
                1249, new Owner(1L, "Jeff", "Jefferson"));
    }

   @Test
   public void shouldFindAllCars() throws Exception {
        List<Bike> bikes = List.of(bike);

        when(showBikePort.findAll()).thenReturn(bikes);

        MockHttpServletResponse response = mvc.perform(
                MockMvcRequestBuilders.get("/api/bikes")
                        .header(HttpHeaders.AUTHORIZATION, jwtToken)
                            .accept(MediaType.APPLICATION_JSON))
                                .andReturn()
                                    .getResponse();

        assertThat(response.getStatus(), is(equalTo(HttpStatus.OK.value())));
        assertThat(response.getContentAsString(), is(equalTo(bikeListJacksonTester.write(bikes).getJson())));
    }

    @Test
    public void shouldFindById() throws Exception {
        when(showBikePort.findById(1L)).thenReturn(bike);

        MockHttpServletResponse response = mvc.perform(
                MockMvcRequestBuilders.get("/api/bikes/1")
                        .header(HttpHeaders.AUTHORIZATION, jwtToken)
                            .accept(MediaType.APPLICATION_JSON))
                                .andReturn()
                                    .getResponse();

        assertThat(response.getStatus(), is(equalTo(HttpStatus.OK.value())));
        assertThat(response.getContentAsString(), is(equalTo(bikeJacksonTester.write(bike).getJson())));
    }
}