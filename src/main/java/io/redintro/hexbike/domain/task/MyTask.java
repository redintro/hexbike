package io.redintro.hexbike.domain.task;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyTask.class);

    @Scheduled(cron = "${schedule.frequency.mytask}")
    @SchedulerLock(name = "${schedule.lock.name}",
            lockAtLeastFor = "${schedule.lock.lockAtLeastFor}",
            lockAtMostFor = "${schedule.lock.lockAtMostFor}")
    public void execute() {
        LOGGER.info("-- MyTask execute() called");
    }
}
