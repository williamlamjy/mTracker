package seedu.mtracker;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogHelper {

    public static final String LOG_FILE_NAME = "logger.log";

    public static final String LOG_FILE_ERROR = "Log file not working!";
    public static final String LOG_INVALID_NAME = "User tried to enter an invalid name here";
    public static final String LOG_INVALID_PRICE = "User tried to enter an invalid price here";
    public static final String LOG_INVALID_SENTIMENT = "User tried to enter an invalid sentiment here";
    public static final String LOG_EMPTY_PAST_RETURNS = "User left past returns empty. Defaulting to double -101.0";

    private static LogHelper logHelper;
    private final Logger logger;

    private LogHelper() {
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        setupLogger();
    }

    public static LogHelper getInstance() {
        if (logHelper == null) {
            logHelper = new LogHelper();
        }
        return logHelper;
    }


    public Logger getLogger() {
        return logger;
    }

    public void setupLogger() {
        LogManager.getLogManager().reset();
        logger.setLevel(Level.INFO);

        try {
            FileHandler logFile = new FileHandler(LOG_FILE_NAME);
            logFile.setLevel(Level.INFO);
            logger.addHandler(logFile);
        } catch (IOException e) {
            logger.log(Level.SEVERE, LOG_FILE_ERROR, e);
        }
    }
}
