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
    private static final String[] COMPONENT_FOR_EXIT = { ExitCommand.COMMAND_WORD };

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
        //command.setData(instrumentManager, ui); uncomment after initialising ui and command
    }

}
