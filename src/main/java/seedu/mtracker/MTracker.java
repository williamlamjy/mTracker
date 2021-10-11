package seedu.mtracker;

import seedu.mtracker.commands.Command;
import seedu.mtracker.commands.ExitCommand;
import seedu.mtracker.commands.InvalidCommand;
import seedu.mtracker.console.InputParser;
import seedu.mtracker.instrument.InstrumentManager;
import seedu.mtracker.ui.TextUi;

public class MTracker {

    private InstrumentManager instrumentManager;
    private InputParser parser;
    private LogHelper logger;

    public MTracker() {
        instrumentManager = InstrumentManager.getInstance();
        parser = new InputParser();
        logger = new LogHelper();
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
