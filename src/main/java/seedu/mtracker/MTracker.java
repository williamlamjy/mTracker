package seedu.mtracker;

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

    }

    /**
     * Main entry-point for the mTracker application.
     */
    public static void main(String[] args) {
        new MTracker().run();
        //command.setData(instrumentManager, ui); uncomment after initialising ui and command
    }

}
