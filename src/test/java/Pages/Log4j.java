package Pages;

import org.apache.log4j.Logger;

public class Log4j {
    private static Logger logger = Logger.getLogger(Log4j.class.getName());

    //Info
    public static void info(String message) {
        logger.info(message);
    }
}
