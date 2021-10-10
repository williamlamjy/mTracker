package seedu.mtracker;

import seedu.mtracker.commands.Command;
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
            TextUi.greetAtStartUp();
            String userInput = InputParser.getUserInput();
            String[] commandComponents = InputParser.getCommandComponents(userInput);
            try {
                command = InputParser.filterByCommandType(commandComponents);
                command.execute();
            } catch (Exception e) {
                TextUi.showErrorMessage(e);
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
