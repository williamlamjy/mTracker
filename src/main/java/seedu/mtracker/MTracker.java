package seedu.mtracker;

import seedu.mtracker.commands.Command;
import seedu.mtracker.commands.ExitCommand;
import seedu.mtracker.commands.InvalidCommand;
import seedu.mtracker.console.InputParser;
import seedu.mtracker.instrument.InstrumentManager;
import seedu.mtracker.ui.TextUi;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MTracker {

    public static final String LOG_FILE_NAME = "logger.log";

    private InstrumentManager instrumentManager;
    private InputParser parser;
    private final Logger logger;

    public MTracker() {
        instrumentManager = InstrumentManager.getInstance();
        parser = new InputParser();
        logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    public void setupLogger() {
        LogManager.getLogManager().reset();
        logger.setLevel(Level.WARNING);

        try {
            FileHandler logFile = new FileHandler(LOG_FILE_NAME);
            logFile.setLevel(Level.WARNING);
            logger.addHandler(logFile);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Log file not working!", e);
        }
    }

    public void run() {
        setupLogger();
        Command command;
        String userInput;
        String[] commandComponents;

        do {
            userInput = parser.getUserInput();
            commandComponents = parser.getCommandComponents(userInput);
            try {
                command = parser.filterByCommandType(commandComponents);
                command.setData(instrumentManager);
                command.execute();
            } catch (Exception e) {
                TextUi.showErrorMessage(e);
                command = new InvalidCommand();
            }
        } while (!(command instanceof ExitCommand));
    }

    public void executeProgram() {
        TextUi.greetAtStartUp();
        run();
    }

    /**
     * Main entry-point for the mTracker application.
     */
    public static void main(String[] args) {
        new MTracker().executeProgram();
    }

}
