package seedu.mtracker;

import seedu.mtracker.commands.Command;
import seedu.mtracker.console.InputParser;
import seedu.mtracker.error.InvalidCommandError;
import seedu.mtracker.instrument.InstrumentManager;
import seedu.mtracker.ui.TextUi;

import java.util.Scanner;

public class MTracker {

    private InstrumentManager instrumentManager;

    public MTracker() {
        instrumentManager = InstrumentManager.getInstance();
    }

    public void run() {
        TextUi.greetAtStartUp();
        String userInput = InputParser.getUserInput();
        String[] components = InputParser.getCommandComponents(userInput);
        try {
            Command c = InputParser.filterByCommandType(components);
            c.execute();
        } catch (InvalidCommandError e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
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
