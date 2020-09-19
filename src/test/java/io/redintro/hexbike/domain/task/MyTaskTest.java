package io.redintro.hexbike.domain.task;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import redis.embedded.RedisServer;

import java.time.Duration;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class MyTaskTest {
    private final static long TEN_SECONDS = 10L;

    @SpyBean
    private MyTask myTask;

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
    public void shouldRunMyTask() {
        assert(true);
        await()
            .atMost(Duration.ofSeconds(TEN_SECONDS))
            .untilAsserted(() -> verify(myTask, atLeastOnce())
            .execute());
    }
}
