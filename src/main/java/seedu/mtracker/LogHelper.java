package seedu.mtracker;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * A class responsible for handling the error logging and the messages to log.
 */
public class LogHelper {

    public static final String LOG_FILE_NAME = "logger.log";
    public static final String LOG_FILE_ERROR = "Log file not working!";

    public static final String LOG_INVALID_NAME = "User tried to enter an invalid name here";
    public static final String LOG_INVALID_PRICE = "User tried to enter an invalid price here";
    public static final String LOG_INVALID_SENTIMENT = "User tried to enter an invalid sentiment here";
    public static final String LOG_INVALID_PAST_RETURNS = "Invalid Past returns entered. Default: double -101.0";
    public static final String LOG_INVALID_EXPIRY = "User gave an invalid expiry input";
    public static final String LOG_INVALID_INSTRUMENT = "User tried to add an invalid instrument type here";
    public static final String LOG_INVALID_COMMAND = "User entered an invalid command to console here";

    public static final String LOG_DATA_FILE_LOAD_ERROR = "mtracker storage text file not loading";
    public static final String LOG_DATA_FILE_WRITE_ERROR = "Writing to storage text file not loading";
    public static final String LOG_DATA_FILE_INSTRUMENT_TYPE_CORRUPTED_ERROR = "Instrument type in storage text "
            + "file got corrupted";
    public static final String LOG_DATA_FILE_INSTRUMENT_CORRUPTED_ERROR = "Instrument in storage text file "
            + "got corrupted";

    private static LogHelper logHelper;
    private final Logger logger;

    private LogHelper() {
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        setupLogger();
    }

    /**
     * Checks and create an instance of logHelper if it does not exist.
     *
     * @return The main instance of logHelper.
     */
    public static LogHelper getInstance() {
        if (logHelper == null) {
            logHelper = new LogHelper();
        }
        return logHelper;
    }


    public Logger getLogger() {
        return logger;
    }

    /**
     * Prepares the log files and set the logging level.
     */
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
