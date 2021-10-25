package seedu.mtracker.commands;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.util.ArrayList;

public class FindCommand extends Command {
    public static final String COMMAND_WORD = "find";
    public static final String EMPTY_STR = "";
    private String keyword;
    private ArrayList<Instrument> filteredInstruments;

    public FindCommand() {
        keyword = EMPTY_STR;
    }

    public void setKeyword(String searchString) {
        keyword = searchString;
    }

    public String getKeyword() {
        return keyword;
    }

    @Override
    public String execute() {
        filteredInstruments = instrumentManager.findInstruments(keyword);
        TextUi.displayInstrumentsFound(filteredInstruments, keyword);
        return COMMAND_WORD;
    }
}
