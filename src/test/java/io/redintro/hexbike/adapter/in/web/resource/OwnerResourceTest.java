package io.redintro.hexbike.adapter.in.web.resource;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class OwnerResourceTest {
    @Test
    public void shouldCreateOwnerResource() {
        OwnerResource ownerResource = new OwnerResource(1L, "Jeff", "Jefferson");

        assertThat(ownerResource.getId(), is(equalTo(1L)));
        assertThat(ownerResource.getFirstName(), is(equalTo("Jeff")));
        assertThat(ownerResource.getLastName(), is(equalTo("Jefferson")));
    }
}