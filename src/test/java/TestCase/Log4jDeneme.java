package TestCase;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;


public class Log4jDeneme {

    private static Logger logger = (Logger) LogManager.getLogger(Log4jDeneme.class);

    public static void main(String[] args) {

        System.out.println("\n   Hello world     \n");

        logger.fatal("fatal log message");
        logger.error("error log message");
        logger.warn("warn log message");
        logger.info("info log message");
        logger.debug("debug log message");
        logger.trace("trace log message");

        System.out.println("\n   Completed     \n");
    }
}
