package io.redintro.hexbike.shared.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "schedule")
public class SchedulerProps {
    public static class Frequency {
        private String pattern;

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }
    }

    public static class Lock {
        private String name;
        private String atLeastFor;
        private String atMostFor;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAtLeastFor() {
            return atLeastFor;
        }

        public void setAtLeastFor(String atLeastFor) {
            this.atLeastFor = atLeastFor;
        }

        public String getAtMostFor() {
            return atMostFor;
        }

        public void setAtMostFor(String atMostFor) {
            this.atMostFor = atMostFor;
        }
    }

    private Frequency frequency;
    private Lock lock;

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }
}
