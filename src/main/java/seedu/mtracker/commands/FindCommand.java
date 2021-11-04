package seedu.mtracker.commands;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.util.ArrayList;

//@@author KVignesh122
public class FindCommand extends Command {
    public static final String COMMAND_WORD = "find";
    public static final String EMPTY_STR = "";
    private String searchString;

    public FindCommand() {
        searchString = EMPTY_STR;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    @Override
    public String execute() {
        ArrayList<Instrument> filteredInstruments = instrumentManager.findInstruments(searchString);
        TextUi.displayInstrumentsFound(filteredInstruments, searchString);
        return COMMAND_WORD;
    }
}
