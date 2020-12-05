package io.redintro.hexbike.adapter.in.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.redintro.hexbike.adapter.in.web.mapper.BikeInMapper;
import io.redintro.hexbike.adapter.in.web.resource.BikeResource;
import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.domain.Owner;
import io.redintro.hexbike.port.in.ShowBikePort;
import io.redintro.hexbike.service.AuthenticationService;
import io.redintro.hexbike.service.HexBikeUserDetailsService;
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
import org.springframework.security.core.userdetails.User;

import javax.persistence.EntityNotFoundException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(BikeController.class)
class BikeControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ShowBikePort showBikePort;

    @MockBean
    private HexBikeUserDetailsService userDetailsService;

    private JacksonTester<List<BikeResource>> jacksonListTester;

    private JacksonTester<BikeResource> jacksonTester;

    private String jwtToken;

    @BeforeEach
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());

        jwtToken = AuthenticationService.getToken("admin");

        when(userDetailsService.loadUserByUsername(any(String.class)))
                .thenReturn(new User("admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG",
                        true, true, true, true,
                        AuthorityUtils.createAuthorityList("ADMIN")));
    }

   @Test
   public void shouldFindAll() throws Exception {
        List<Bike> bikes = List.of(Bike.getInstance(UUID.randomUUID(), "Cinelli", "Vigorelli", "White", 2017,
                1249, Owner.getInstance(UUID.randomUUID(), "Jeff", "Jefferson")));

        when(showBikePort.findAll()).thenReturn(bikes);

        MockHttpServletResponse response = mvc.perform(
                MockMvcRequestBuilders.get("/api/bikes")
                    .header(HttpHeaders.AUTHORIZATION, jwtToken)
                    .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        List<BikeResource> bikeResources = BikeInMapper.mapToListResource(bikes);

        assertThat(response.getStatus(), is(equalTo(HttpStatus.OK.value())));
        assertThat(response.getContentAsString(), is(equalTo(jacksonListTester.write(bikeResources).getJson())));
    }

    @Test
    public void shouldFindById() throws Exception {
        UUID bikeId = UUID.randomUUID();
        UUID ownerId = UUID.randomUUID();

        Bike bike = Bike.getInstance(bikeId, "Cinelli", "Vigorelli", "White", 2017, 1249,
                Owner.getInstance(ownerId, "Jeff", "Jefferson"));

        when(showBikePort.findById(bikeId)).thenReturn(Optional.of(bike));

        MockHttpServletResponse response = mvc.perform(
                MockMvcRequestBuilders.get("/api/bikes/" + bikeId)
                    .header(HttpHeaders.AUTHORIZATION, jwtToken)
                    .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        Optional<BikeResource> bikeResource = BikeInMapper.mapToResource(bike);

        assertThat(response.getStatus(), is(equalTo(HttpStatus.OK.value())));
        assertThat(response.getContentAsString(), is(equalTo(jacksonTester.write(bikeResource.get()).getJson())));
    }

    @Test
    public void shouldFailToFindById() throws Exception {
        UUID bikeId = UUID.randomUUID();

        when(showBikePort.findById(bikeId)).thenReturn(Optional.empty());

        MockHttpServletResponse response = mvc.perform(
                MockMvcRequestBuilders.get("/api/bikes/" + bikeId)
                    .header(HttpHeaders.AUTHORIZATION, jwtToken)
                    .accept(MediaType.APPLICATION_JSON))
               .andReturn()
               .getResponse();

        assertThat(response.getStatus(), is(equalTo(HttpStatus.NOT_FOUND.value())));
    }
}