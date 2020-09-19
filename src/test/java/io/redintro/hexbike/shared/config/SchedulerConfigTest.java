package io.redintro.hexbike.shared.config;

import net.javacrumbs.shedlock.core.LockProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import redis.embedded.RedisServer;

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

    @Value("${spring.redis.port}")
    private int redisPort;

    private RedisServer embeddedRedisServer;

    @BeforeEach
    public void setUp() {
        embeddedRedisServer = new RedisServer(redisPort);
        embeddedRedisServer.start();
    }

    @AfterEach
    public void tearDown() {
        embeddedRedisServer.stop();
    }

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
