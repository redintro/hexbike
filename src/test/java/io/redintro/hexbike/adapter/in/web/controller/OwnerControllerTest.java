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
import java.util.UUID;
import java.util.stream.Collectors;

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
        List<Owner> owners = List.of(new Owner(UUID.randomUUID(),"Jeff", "Jefferson"));

        when(showOwnerPort.findAll()).thenReturn(owners);

        MockHttpServletResponse response = mvc.perform(
                MockMvcRequestBuilders.get("/api/owners")
                        .accept(MediaType.APPLICATION_JSON))
                            .andReturn()
                                .getResponse();

        List<OwnerResource> ownerResources = owners.stream()
                .map(OwnerInMapper::mapToResource)
                .collect(Collectors.toList());

        assertThat(response.getStatus(), is(equalTo(HttpStatus.OK.value())));
        assertThat(response.getContentAsString(), is(equalTo(jacksonListTester.write(ownerResources).getJson())));
    }

    @Test
    public void shouldFindById() throws Exception {
        UUID ownerId = UUID.randomUUID();

        Owner owner = new Owner(ownerId, "Jeff", "Jefferson");

        when(showOwnerPort.findById(ownerId)).thenReturn(owner);

        MockHttpServletResponse response = mvc.perform(
                MockMvcRequestBuilders.get("/api/owners/" + ownerId)
                        .accept(MediaType.APPLICATION_JSON))
                            .andReturn()
                                .getResponse();

        OwnerResource ownerResource = OwnerInMapper.mapToResource(owner);

        assertThat(response.getStatus(), is(equalTo(HttpStatus.OK.value())));
        assertThat(response.getContentAsString(), is(equalTo(jacksonTester.write(ownerResource).getJson())));
    }
}
