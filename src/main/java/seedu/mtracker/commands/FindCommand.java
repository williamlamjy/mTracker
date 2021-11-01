package seedu.mtracker.commands;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.util.ArrayList;

public class FindCommand extends Command {
    public static final String COMMAND_WORD = "find";
    public static final String EMPTY_STR = "";
    private String searchString;
    private ArrayList<Instrument> filteredInstruments;

    public FindCommand() {
        searchString = EMPTY_STR;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getSearchString() {
        return searchString;
    }

    @Override
    public String execute() {
        filteredInstruments = instrumentManager.findInstruments(searchString);
        TextUi.displayInstrumentsFound(filteredInstruments, searchString);
        return COMMAND_WORD;
    }
}
