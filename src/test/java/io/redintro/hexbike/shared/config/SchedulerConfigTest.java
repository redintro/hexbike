package io.redintro.hexbike.shared.config;

import net.javacrumbs.shedlock.core.LockProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class SchedulerConfigTest {
    @Autowired
    private SchedulerConfig schedulerConfig;

    @Autowired
    private LockProvider lockProvider;

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    @Test
    public void shouldInitialiseSchedulerConfig() {
        assertThat(schedulerConfig, is(notNullValue()));
    }

    @Test
    public void shouldInitialiseLockProvider() {
        assertThat(lockProvider, is(notNullValue()));
    }

    @Test
    public void shouldInitialiseTaskScheduler() {
        assertThat(taskScheduler, is(notNullValue()));
    }
}
