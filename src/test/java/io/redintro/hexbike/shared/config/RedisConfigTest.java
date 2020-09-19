package io.redintro.hexbike.shared.config;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.embedded.RedisServer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class RedisConfigTest {
    @Autowired
    private RedisConfig redisConfig;

    @Autowired
    private JedisConnectionFactory redisConnectionFactory;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Value("${spring.redis.host}")
    private String redisHost;

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
    public void shouldInitialiseRedisConfig() {
        assertThat(redisConfig, is(notNullValue()));
    }

    @Test
    public void shouldInitialiseJedisConnectionFactory() {
        assertThat(redisConnectionFactory, is(notNullValue()));
        assertThat(redisConnectionFactory.getHostName(), is(equalTo(redisHost)));
        assertThat(redisConnectionFactory.getPort(), is(equalTo(redisPort)));
        assertThat(redisConnectionFactory.getConnection(), is(instanceOf(RedisConnection.class)));
    }

    @Test
    public void shouldInitialiseRedisTemplate() {
        assertThat(redisTemplate, is(notNullValue()));
    }
}
