package seedu.mtracker;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogHelper {

    public static final String LOG_FILE_NAME = "logger.log";

    public static final String LOG_FILE_ERROR = "Log file not working!";

    private final Logger logger;

    public LogHelper() {
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        setupLogger();
    }

    public void setupLogger() {
        LogManager.getLogManager().reset();
        logger.setLevel(Level.WARNING);

        try {
            FileHandler logFile = new FileHandler(LOG_FILE_NAME);
            logFile.setLevel(Level.WARNING);
            logger.addHandler(logFile);
        } catch (IOException e) {
            logger.log(Level.SEVERE, LOG_FILE_ERROR, e);
        }
    }
}
