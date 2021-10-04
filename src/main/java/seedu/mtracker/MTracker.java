package seedu.mtracker;

import seedu.mtracker.instrument.Instrument;
import seedu.mtracker.instrument.InstrumentManager;

import java.util.ArrayList;
import java.util.Scanner;

public class MTracker {
    private ArrayList<Instrument> instruments = new ArrayList<>();
    private InstrumentManager instrumentManager = new InstrumentManager(instruments);
    //arraylist to initialise Instrument manager as future pre-existing instrument array can be input here
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("What is your name?");

        Scanner in = new Scanner(System.in);
        //command.setData(instruments, ui); uncomment after initialising ui and command
        System.out.println("Hello " + in.nextLine());
    }
}
