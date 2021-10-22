package seedu.mtracker.commands;

import seedu.mtracker.model.Instrument;

import java.util.ArrayList;

public class FindCommand extends Command {
    public static final String COMMAND_WORD = "find";
    public static final String EMPTY_STR = "";
    private String keyword;
    private ArrayList<Instrument> instruments;

    public FindCommand() {
        keyword = EMPTY_STR;
    }

    @Override
    public String execute() {
        instruments = instrumentManager.getInstruments();

        return COMMAND_WORD;
    }
}
