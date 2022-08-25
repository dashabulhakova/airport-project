package functionalInterface;

import org.apache.log4j.Logger;
public class NewThread extends Thread{
    private static final Logger LOGGER = Logger.getLogger(NewThread.class.getName());
                @Override
                public void run() {
                    super.run();
                    LOGGER.info("Thread is running");
                }

}
