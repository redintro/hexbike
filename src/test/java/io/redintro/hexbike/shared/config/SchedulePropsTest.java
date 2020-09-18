package io.redintro.hexbike.shared.config;

import io.redintro.hexbike.HexBikeApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest(classes = HexBikeApplication.class)
@TestPropertySource("classpath:application.properties")
public class SchedulePropsTest {
    @Autowired
    private SchedulerProps schedulerProps;

    @Test
    public void shouldReturnPropertyValueWhenPropertyQueried() throws Exception {
        assertThat(schedulerProps.getFrequency().getPattern(), is(equalTo("*/10 * * * * ?")));
        assertThat(schedulerProps.getLock().getName(), is(equalTo("mytask-execute")));
        assertThat(schedulerProps.getLock().getAtLeastFor(), is(equalTo("PT5S")));
        assertThat(schedulerProps.getLock().getAtMostFor(), is(equalTo("PT5S")));
    }
}
