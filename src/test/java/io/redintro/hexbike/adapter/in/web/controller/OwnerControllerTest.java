package io.redintro.hexbike.adapter.in.web.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.redintro.hexbike.domain.Owner;
import io.redintro.hexbike.port.in.ShowOwnerPort;
import io.vavr.control.Option;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class OwnerControllerTest {
  private MockMvc mvc;

  @InjectMocks private OwnerController controller;

  @Mock private ShowOwnerPort showOwnerPort;

  @BeforeEach
  public void setUp() {
    mvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  public void shouldFindAllOwners() throws Exception {
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");
    final String firstName = "Jeff";
    final String lastName = "Jefferson";

    final List<Owner> owners = List.of(Owner.getInstance(ownerId, firstName, lastName));

    when(showOwnerPort.findAll()).thenReturn(owners);

    final MockHttpServletResponse response =
        mvc.perform(MockMvcRequestBuilders.get("/api/owners").accept(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();

    final DocumentContext jsonContext = JsonPath.parse(response.getContentAsString());

    assertThat(response.getStatus(), is(equalTo(HttpStatus.OK.value())));
    assertThat(jsonContext.read("$[0]['id']"), is(equalTo(ownerId.toString())));
    assertThat(jsonContext.read("$[0]['firstName']"), is(equalTo(firstName)));
    assertThat(jsonContext.read("$[0]['lastName']"), is(equalTo(lastName)));
  }

  @Test
  public void shouldFindById() throws Exception {
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");
    final String firstName = "Jeff";
    final String lastName = "Jefferson";

    final Owner owner = Owner.getInstance(ownerId, firstName, lastName);

    when(showOwnerPort.findById(ownerId)).thenReturn(Option.of(owner));

    MockHttpServletResponse response =
        mvc.perform(
                MockMvcRequestBuilders.get("/api/owners/" + ownerId)
                    .accept(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();

    final DocumentContext jsonContext = JsonPath.parse(response.getContentAsString());

    assertThat(response.getStatus(), is(equalTo(HttpStatus.OK.value())));
    assertThat(jsonContext.read("$['id']"), is(equalTo(ownerId.toString())));
    assertThat(jsonContext.read("$['firstName']"), is(equalTo(firstName)));
    assertThat(jsonContext.read("$['lastName']"), is(equalTo(lastName)));
  }

  @Test
  public void shouldFailToFindById() throws Exception {
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");

    when(showOwnerPort.findById(ownerId)).thenReturn(Option.none());

    MockHttpServletResponse response =
        mvc.perform(
                MockMvcRequestBuilders.get("/api/owners/" + ownerId)
                    .accept(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();

    assertThat(response.getStatus(), is(equalTo(HttpStatus.NOT_FOUND.value())));
  }
}
