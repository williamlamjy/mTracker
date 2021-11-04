package seedu.mtracker.commands;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

//@@author KVignesh122
public class ViewCommand extends IndexedCommand {
    public static final String COMMAND_WORD = "view";

    public ViewCommand() {
        index = UNINITIALISED_INDEX;
    }

    @Override
    public String execute() {
        Instrument instrumentToView = getInstrumentAtIndex();
        TextUi.displaySpecificInstrumentView(instrumentToView);
        return COMMAND_WORD;
    }
}
