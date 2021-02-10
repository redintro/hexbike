package io.redintro.hexbike.adapter.in.web.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.redintro.hexbike.domain.Bike;
import io.redintro.hexbike.port.in.ShowBikePort;
import io.redintro.hexbike.service.AuthenticationService;
import io.redintro.hexbike.service.HexBikeUserDetailsService;
import io.vavr.control.Option;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(BikeController.class)
class BikeControllerTest {
  @Autowired private MockMvc mvc;

  @MockBean private ShowBikePort showBikePort;

  @MockBean private HexBikeUserDetailsService userDetailsService;

  private String jwtToken;

  @BeforeEach
  public void setUp() {
    jwtToken = AuthenticationService.getToken("admin");

    when(userDetailsService.loadUserByUsername(any(String.class)))
        .thenReturn(
            new User(
                "admin",
                "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG",
                true,
                true,
                true,
                true,
                AuthorityUtils.createAuthorityList("ADMIN")));
  }

  @Test
  public void shouldFindAll() throws Exception {
    final UUID bikeId = UUID.fromString("11edf58d-0d27-470f-a527-3bab79ba5576");
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");
    final String make = "Cinelli";
    final String model = "Vigorelli";
    final String colour = "White";
    final int year = 2017;
    final int price = 1249;

    final List<Bike> bikes =
        List.of(Bike.getInstance(bikeId, ownerId, make, model, colour, year, price));

    when(showBikePort.findAll()).thenReturn(bikes);

    final MockHttpServletResponse response =
        mvc.perform(
                MockMvcRequestBuilders.get("/api/bikes")
                    .header(HttpHeaders.AUTHORIZATION, jwtToken)
                    .accept(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();

    final DocumentContext jsonContext = JsonPath.parse(response.getContentAsString());

    assertThat(jsonContext.read("$[0]['id']"), is(equalTo(bikeId.toString())));
    assertThat(jsonContext.read("$[0]['ownerId']"), is(equalTo(ownerId.toString())));
    assertThat(jsonContext.read("$[0]['make']"), is(equalTo("Cinelli")));
    assertThat(jsonContext.read("$[0]['model']"), is(equalTo("Vigorelli")));
    assertThat(jsonContext.read("$[0]['colour']"), is(equalTo("White")));
    assertThat(jsonContext.read("$[0]['year']"), is(equalTo(2017)));
    assertThat(jsonContext.read("$[0]['price']"), is(equalTo(1249)));
  }

  @Test
  public void shouldFindById() throws Exception {
    final UUID bikeId = UUID.fromString("11edf58d-0d27-470f-a527-3bab79ba5576");
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");
    final String make = "Cinelli";
    final String model = "Vigorelli";
    final String colour = "White";
    final int year = 2017;
    final int price = 1249;

    final Bike bike = Bike.getInstance(bikeId, ownerId, make, model, colour, year, price);

    when(showBikePort.findById(bikeId)).thenReturn(Option.of(bike));

    final MockHttpServletResponse response =
        mvc.perform(
                MockMvcRequestBuilders.get("/api/bikes/" + bikeId)
                    .header(HttpHeaders.AUTHORIZATION, jwtToken)
                    .accept(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();

    final DocumentContext jsonContext = JsonPath.parse(response.getContentAsString());

    assertThat(jsonContext.read("$['id']"), is(equalTo(bikeId.toString())));
    assertThat(jsonContext.read("$['ownerId']"), is(equalTo(ownerId.toString())));
    assertThat(jsonContext.read("$['make']"), is(equalTo("Cinelli")));
    assertThat(jsonContext.read("$['model']"), is(equalTo("Vigorelli")));
    assertThat(jsonContext.read("$['colour']"), is(equalTo("White")));
    assertThat(jsonContext.read("$['year']"), is(equalTo(2017)));
    assertThat(jsonContext.read("$['price']"), is(equalTo(1249)));
  }

  @Test
  public void shouldFailToFindById() throws Exception {
    final UUID bikeId = UUID.fromString("11edf58d-0d27-470f-a527-3bab79ba5576");

    when(showBikePort.findById(bikeId)).thenReturn(Option.none());

    final MockHttpServletResponse response =
        mvc.perform(
                MockMvcRequestBuilders.get("/api/bikes/" + bikeId)
                    .header(HttpHeaders.AUTHORIZATION, jwtToken)
                    .accept(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();

    assertThat(response.getStatus(), is(equalTo(HttpStatus.NOT_FOUND.value())));
  }
}
