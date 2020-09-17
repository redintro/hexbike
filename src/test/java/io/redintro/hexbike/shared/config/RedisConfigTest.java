package io.redintro.hexbike.shared.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisListCommands;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

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

    @Test
    public void shouldInitialiseRedisConfig() {
        assertThat(redisConfig, is(notNullValue()));
    }

    @Test
    public void shouldInitialiseJedisConnectionFactory() {
        assertThat(redisConnectionFactory, is(notNullValue()));
        assertThat(redisConnectionFactory.getHostName(), is(equalTo(redisHost)));
        assertThat(redisConnectionFactory.getPort(), is(equalTo(redisPort)));
    }

    @Test
    public void shouldInitialiseRedisTemplate() {
        assertThat(redisTemplate, is(notNullValue()));
    }
}
