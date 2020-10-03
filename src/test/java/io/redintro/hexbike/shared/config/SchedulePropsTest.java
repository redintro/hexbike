package io.redintro.hexbike.shared.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest()
public class SchedulePropsTest {
    @Autowired
    private SchedulerProps schedulerProps;

    @Test
    public void shouldReturnPropertyValueWhenPropertyQueried() throws Exception {
        assertThat(schedulerProps.isEnabled(), is(equalTo(false)));
        assertThat(schedulerProps.getFrequency().getPattern(), is(equalTo("0 */1 * * * ?")));
        assertThat(schedulerProps.getLock().getNameSpace(), is(equalTo("hexbike")));
        assertThat(schedulerProps.getLock().getAtLeastFor(), is(equalTo("PT30S")));
        assertThat(schedulerProps.getLock().getAtMostFor(), is(equalTo("PT30S")));
    }
}
