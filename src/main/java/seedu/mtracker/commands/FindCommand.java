package seedu.mtracker.commands;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.util.ArrayList;

public class FindCommand extends Command {
    public static final String COMMAND_WORD = "find";
    public static final String EMPTY_STR = "";
    private String keyword;
    private ArrayList<Instrument> instruments;

    public FindCommand() {
        keyword = EMPTY_STR;
    }

    public void setKeyword(String searchString) {
        keyword = searchString;
    }

    public void getKeyword() {
        return keyword;
    }

    @Override
    public String execute() {
        instruments = instrumentManager.getInstruments();
        TextUi.displayInstrumentsFound(instruments, );
        return COMMAND_WORD;
    }
}
