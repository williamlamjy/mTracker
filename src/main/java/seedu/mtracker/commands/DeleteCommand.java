package seedu.mtracker.commands;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

public class DeleteCommand extends IndexedCommand {
    public static final String COMMAND_WORD = "delete";

    public DeleteCommand() {
        index = UNINITIALISED_INDEX;
    }

    @Override
    public String execute() {
        Instrument instrumentToDelete = getInstrumentAtIndex();
        instrumentManager.deleteInstrument(index);
        TextUi.displayInstrumentDeleted(instrumentToDelete);
        return COMMAND_WORD;
    }
}
