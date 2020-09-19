package io.redintro.hexbike.shared.config;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.redis.spring.RedisLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
public class SchedulerConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(SchedulerConfig.class);

    private static final String LOCK_NAMESPACE = "hexbike";

    @Bean
    public LockProvider lockProvider(RedisConnectionFactory connectionFactory) {
        LOGGER.info("lockProvider initialised");
        return new RedisLockProvider(connectionFactory, LOCK_NAMESPACE);
    }

    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(5);
        threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
        LOGGER.info("taskScheduler initialised");
        return threadPoolTaskScheduler;
    }
}
