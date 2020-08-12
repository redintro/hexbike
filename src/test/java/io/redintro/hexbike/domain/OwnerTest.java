package io.redintro.hexbike.domain;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class OwnerTest {
    @Test
    public void shouldCreateOwner() {
        Owner owner = new Owner(1L, "Jeff", "Jefferson");

        assertThat(owner.getId(), is(equalTo(1L)));
        assertThat(owner.getFirstName(), is(equalTo("Jeff")));
        assertThat(owner.getLastName(), is(equalTo("Jefferson")));
    }
}