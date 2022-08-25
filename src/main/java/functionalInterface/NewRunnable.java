package functionalInterface;

import org.apache.log4j.Logger;

import java.lang.management.RuntimeMXBean;

public class NewRunnable implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(NewRunnable.class.getName());

    @Override
    public void run() {
        LOGGER.info("This runnable is running");
    }
}
