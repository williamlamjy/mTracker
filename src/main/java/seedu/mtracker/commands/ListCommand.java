package seedu.mtracker.commands;

import seedu.mtracker.instrument.Instrument;
import java.util.ArrayList;

public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    private ArrayList<Instrument> instruments;

    public ListCommand(){
        setData();
        instruments = instrumentManager.getInstruments();
    }

    @Override
    public String execute() {
        System.out.println(instruments.size());
        for (Instrument i : instruments) {
            System.out.println(i.toString() + i.getCurrentPrice());
        }
        return COMMAND_WORD;
    }
}
