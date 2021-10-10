package seedu.mtracker.commands;

import seedu.mtracker.instrument.Instrument;
import java.util.ArrayList;

public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";
    private static final String SPACE = " Current Price: ";

    private ArrayList<Instrument> instruments;

    @Override
    public String execute() {
        instruments = instrumentManager.getInstruments();
        for (Instrument i : instruments) {
            System.out.println(i.toString() + SPACE + i.getCurrentPrice());
        }
        return COMMAND_WORD;
    }
}
