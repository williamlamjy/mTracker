package seedu.mtracker.commands;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.util.ArrayList;

//@@author KVignesh122
/**
 * Responsible for the command that find instruments containing a specific keyword in the name parameter.
 */
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

    /**
     * Handles the execution of the finding of instruments.
     *
     * @return The name of the command.
     */
    @Override
    public String execute() {
        ArrayList<Instrument> filteredInstruments = instrumentManager.findInstruments(searchString);
        TextUi.displayInstrumentsFound(filteredInstruments, searchString);
        return COMMAND_WORD;
    }
}
