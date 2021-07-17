package io.redintro.hexbike.adapter.in.scheduled;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTask {
  private static final Logger LOGGER = LoggerFactory.getLogger(MyTask.class);

  @Scheduled(cron = "${io.redintro.scheduling.frequency.pattern}")
  @SchedulerLock(
      name = "io.redintro.scheduling.lock.name.my-task",
      lockAtLeastFor = "${io.redintro.scheduling.lock.atLeastFor}",
      lockAtMostFor = "${io.redintro.scheduling.lock.atMostFor}")
  public void execute() {
    LOGGER.info("Scheduled task called [{}]", this.toString());
  }
}
