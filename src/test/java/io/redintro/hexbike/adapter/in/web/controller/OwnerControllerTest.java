package io.redintro.hexbike.adapter.in.web.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.redintro.hexbike.adapter.in.web.mapper.OwnerInMapper;
import io.redintro.hexbike.adapter.in.web.resource.OwnerResource;
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
import org.springframework.boot.test.json.JacksonTester;
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

  private JacksonTester<List<OwnerResource>> jacksonListTester;

  private JacksonTester<OwnerResource> jacksonTester;

  @BeforeEach
  public void setUp() {
    JacksonTester.initFields(this, new ObjectMapper());

    mvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  public void shouldFindAllOwners() throws Exception {
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");
    final UUID bikeId = UUID.fromString("11edf58d-0d27-470f-a527-3bab79ba5576");

    List<Owner> owners = List.of(Owner.getInstance(UUID.randomUUID(), "Jeff", "Jefferson"));

    when(showOwnerPort.findAll()).thenReturn(owners);

    MockHttpServletResponse response =
        mvc.perform(MockMvcRequestBuilders.get("/api/owners").accept(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();

    List<OwnerResource> ownerResources = OwnerInMapper.mapToListRestResource(owners);

    assertThat(response.getStatus(), is(equalTo(HttpStatus.OK.value())));
    assertThat(
        response.getContentAsString(),
        is(equalTo(jacksonListTester.write(ownerResources).getJson())));
  }

  @Test
  public void shouldFindById() throws Exception {
    final UUID ownerId = UUID.fromString("40b8098d-8058-465e-acff-ac1119e57b27");
    final UUID bikeId = UUID.fromString("11edf58d-0d27-470f-a527-3bab79ba5576");

    final Owner owner = Owner.getInstance(ownerId, "Jeff", "Jefferson");

    when(showOwnerPort.findById(ownerId)).thenReturn(Option.of(owner));

    MockHttpServletResponse response =
        mvc.perform(
                MockMvcRequestBuilders.get("/api/owners/" + ownerId)
                    .accept(MediaType.APPLICATION_JSON))
            .andReturn()
            .getResponse();

    Option<OwnerResource> ownerResource = OwnerInMapper.mapToRestResource(owner);

    assertThat(response.getStatus(), is(equalTo(HttpStatus.OK.value())));
    assertThat(
        response.getContentAsString(),
        is(equalTo(jacksonTester.write(ownerResource.get()).getJson())));
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
