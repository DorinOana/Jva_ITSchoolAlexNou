package loggerUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class LoggerUtility {
    private static final Logger logger = LogManager.getLogger();

    public static synchronized void startTestCase(String testName){
        ThreadContext.put("threadName", testName);
        logger.info("************** Execution Started : {}**************", testName);
    }

    public static synchronized void endTestCase(String sTestCaseName) {
        logger.info("************** Execution End : {}**************", sTestCaseName);
    }

    public static synchronized void info(Object message){
        logger.info("{}: {}", Thread.currentThread().getName(), message);
    }

    public static synchronized void error(Object message){
        logger.error("{}: {}", Thread.currentThread().getName(), message);
    }
}
