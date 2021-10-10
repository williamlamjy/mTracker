package seedu.mtracker;

import seedu.mtracker.commands.Command;
import seedu.mtracker.commands.ExitCommand;
import seedu.mtracker.commands.InvalidCommand;
import seedu.mtracker.console.InputParser;
import seedu.mtracker.instrument.InstrumentManager;
import seedu.mtracker.ui.TextUi;

public class MTracker {

    private InstrumentManager instrumentManager;

    public MTracker() {
        instrumentManager = InstrumentManager.getInstance();
    }

    public void run() {
        Command command;
        String userInput;
        String[] commandComponents;

        do {
            userInput = InputParser.getUserInput();
            commandComponents = InputParser.getCommandComponents(userInput);
            try {
                command = InputParser.filterByCommandType(commandComponents);
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
