package seedu.mtracker;

import seedu.mtracker.commands.Command;
import seedu.mtracker.commands.ExitCommand;
import seedu.mtracker.commands.InvalidCommand;
import seedu.mtracker.console.InputParser;
import seedu.mtracker.instrument.InstrumentManager;
import seedu.mtracker.ui.TextUi;

import java.util.logging.Level;

public class MTracker {

    private final InstrumentManager instrumentManager;
    private final InputParser parser;
    private final LogHelper logger;

    public MTracker() {
        instrumentManager = InstrumentManager.getInstance();
        logger = LogHelper.getInstance();
        parser = new InputParser();
    }

    public void run() {
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
                logger.getLogger().log(Level.WARNING, e.getMessage());
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
        assert false : "dummy assertion set to fail";
        new MTracker().executeProgram();
    }

}
