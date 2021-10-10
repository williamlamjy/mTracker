package seedu.mtracker;

import seedu.mtracker.commands.Command;
import seedu.mtracker.commands.ExitCommand;
import seedu.mtracker.console.InputParser;
import seedu.mtracker.instrument.InstrumentManager;
import seedu.mtracker.ui.TextUi;
import java.util.Arrays;

import java.util.Scanner;

public class MTracker {

    private InstrumentManager instrumentManager;
    private static String[] componentForExit = { ExitCommand.COMMAND_WORD };

    public MTracker() {
        instrumentManager = InstrumentManager.getInstance();
    }

    public void run() {
        TextUi.greetAtStartUp();

        Command c;
        String userInput;
        String[] inputComponents = {};
        // Quit program after ExitCommand executed.
        while (!(Arrays.equals(inputComponents, componentForExit))) {
            userInput = InputParser.getUserInput();
            inputComponents = InputParser.getCommandComponents(userInput);
            try {
                c = InputParser.filterByCommandType(inputComponents);
                c.execute();
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
