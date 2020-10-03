package io.redintro.hexbike.shared.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "io.redintro.scheduling")
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
        private String nameSpace;
        private String atLeastFor;
        private String atMostFor;

        public String getNameSpace() {
            return nameSpace;
        }

        public void setNameSpace(String nameSpace) {
            this.nameSpace = nameSpace;
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

    private boolean enabled;
    private Frequency frequency;
    private Lock lock;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

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
