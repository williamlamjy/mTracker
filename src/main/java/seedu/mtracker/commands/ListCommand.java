package seedu.mtracker.commands;

import seedu.mtracker.instrument.Instrument;
import seedu.mtracker.ui.TextUi;

import java.util.ArrayList;

public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    private ArrayList<Instrument> instruments;

    @Override
    public String execute() {
        instruments = instrumentManager.getInstruments();
        for (Instrument i : instruments) {
            TextUi.displayInstruments(i);
        }
        return COMMAND_WORD;
    }
}
