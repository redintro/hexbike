package io.redintro.hexbike.domain.task;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyTask.class);

    @Scheduled(cron = "0 */1 * * * ?")
    @SchedulerLock(name = "do-something", lockAtLeastFor = "PT30S", lockAtMostFor = "PT30S")
    public void doSomething() {
        LOGGER.info("-- MyTask doSomething() called");
    }
}
