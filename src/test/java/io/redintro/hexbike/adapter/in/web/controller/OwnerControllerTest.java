package io.redintro.hexbike.adapter.in.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.redintro.hexbike.adapter.in.web.mapper.OwnerInMapper;
import io.redintro.hexbike.adapter.in.web.resource.OwnerResource;
import io.redintro.hexbike.domain.Owner;
import io.redintro.hexbike.port.in.ShowOwnerPort;
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

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OwnerControllerTest {
    private MockMvc mvc;

    @InjectMocks
    private OwnerController controller;

    @Mock
    private ShowOwnerPort showOwnerPort;

    private JacksonTester<List<OwnerResource>> jacksonListTester;
    private JacksonTester<OwnerResource> jacksonTester;

    @BeforeEach
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());

        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void shouldFindAllOwners() throws Exception {
        List<Owner> owners = List.of(Owner.getInstance(UUID.randomUUID(), "Jeff", "Jefferson"));

        when(showOwnerPort.findAll()).thenReturn(owners);

        MockHttpServletResponse response = mvc.perform(
                MockMvcRequestBuilders.get("/api/owners")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        List<OwnerResource> ownerResources = OwnerInMapper.mapToListResource(owners);

        assertThat(response.getStatus(), is(equalTo(HttpStatus.OK.value())));
        assertThat(response.getContentAsString(), is(equalTo(jacksonListTester.write(ownerResources).getJson())));
    }

    @Test
    public void shouldFindById() throws Exception {
        UUID ownerId = UUID.randomUUID();

        Owner owner = Owner.getInstance(ownerId, "Jeff", "Jefferson");

        when(showOwnerPort.findById(ownerId)).thenReturn(Optional.of(owner));

        MockHttpServletResponse response = mvc.perform(
                MockMvcRequestBuilders.get("/api/owners/" + ownerId)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        Optional<OwnerResource> ownerResource = OwnerInMapper.mapToResource(owner);

        assertThat(response.getStatus(), is(equalTo(HttpStatus.OK.value())));
        assertThat(response.getContentAsString(), is(equalTo(jacksonTester.write(ownerResource.get()).getJson())));
    }

    @Test
    public void shouldFailToFindById() throws Exception {
        UUID ownerId = UUID.randomUUID();

        when(showOwnerPort.findById(ownerId)).thenReturn(Optional.empty());

        MockHttpServletResponse response = mvc.perform(
                MockMvcRequestBuilders.get("/api/owners/" + ownerId)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus(), is(equalTo(HttpStatus.NOT_FOUND.value())));
    }
}
