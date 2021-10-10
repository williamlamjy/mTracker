package seedu.mtracker;

import seedu.mtracker.commands.Command;
import seedu.mtracker.commands.ExitCommand;
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

        Command c;
        String userInput;
        String[] inputComponents = {};
        // Quit program after ExitCommand executed.
        while (!(Arrays.equals(inputComponents, COMPONENT_FOR_EXIT))) {
            userInput = InputParser.getUserInput();
            inputComponents = InputParser.getCommandComponents(userInput);
            try {
                c = InputParser.filterByCommandType(inputComponents);
                c.execute();
            } catch (InvalidCommandError e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
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
