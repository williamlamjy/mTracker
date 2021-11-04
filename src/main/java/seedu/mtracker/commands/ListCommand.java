package seedu.mtracker.commands;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.util.ArrayList;

public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    @Override
    public String execute() {
        ArrayList<Instrument> instruments = instrumentManager.getInstruments();
        TextUi.displayAllInstruments(instruments);
        return COMMAND_WORD;
    }
}
