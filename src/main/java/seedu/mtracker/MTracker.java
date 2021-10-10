package seedu.mtracker;

import seedu.mtracker.commands.Command;
import seedu.mtracker.commands.ExitCommand;
import seedu.mtracker.commands.InvalidCommand;
import seedu.mtracker.console.InputParser;
import seedu.mtracker.error.InvalidCommandError;
import seedu.mtracker.instrument.InstrumentManager;
import seedu.mtracker.ui.TextUi;
import java.util.Arrays;

public class MTracker {

    private InstrumentManager instrumentManager;

    public MTracker() {
        instrumentManager = InstrumentManager.getInstance();
    }

    public void run() {
        TextUi.greetAtStartUp();

        Command command = new InvalidCommand();
        String userInput;
        String[] commandComponents;
        // Quit program after ExitCommand executed.
        while (!(command instanceof ExitCommand)) {
            userInput = InputParser.getUserInput();
            commandComponents = InputParser.getCommandComponents(userInput);
            try {
                command = InputParser.filterByCommandType(commandComponents);
                command.setData(instrumentManager);
                command.execute();
            } catch (Exception e) {
                TextUi.showErrorMessage(e);
            }
        }
    }

    /**
     * Main entry-point for the mTracker application.
     */
    public static void main(String[] args) {
        new MTracker().run();
    }

}
