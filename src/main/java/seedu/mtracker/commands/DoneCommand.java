package seedu.mtracker.commands;

import seedu.mtracker.asserthelpers.AssertCommandHelpers;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

public class DoneCommand extends IndexedCommand {
    public static final String COMMAND_WORD = "done";

    public DoneCommand() {
        index = UNINITIALISED_INDEX;
    }

    @Override
    public String execute() {
        Instrument instrumentToComplete = getInstrumentAtIndex();
        instrumentManager.doneInstrument(index);
        TextUi.displayDoneInstrument(instrumentToComplete);
        return COMMAND_WORD;
    }
}
