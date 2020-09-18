package io.redintro.hexbike.domain.task;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyTask.class);

    @Scheduled(cron = "${schedule.frequency.pattern}")
    @SchedulerLock(name = "${schedule.lock.name}",
            lockAtLeastFor = "${schedule.lock.atLeastFor}",
            lockAtMostFor = "${schedule.lock.atMostFor}")
    public void execute() {
        LOGGER.info("-- MyTask execute() called");
    }
}
