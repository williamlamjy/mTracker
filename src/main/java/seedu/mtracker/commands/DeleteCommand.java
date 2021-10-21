package seedu.mtracker.commands;

import seedu.mtracker.asserthelpers.AssertCommandHelpers;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

public class DeleteCommand extends Command {
    public static final String COMMAND_WORD = "delete";
    public static final int UNINITIALISED_INDEX = -1;
    private int index;

    public DeleteCommand() {
        index = UNINITIALISED_INDEX;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String execute() {
        AssertCommandHelpers.assertIndexWithinBounds(instrumentManager.getSize(), index);
        Instrument instrumentToDelete = instrumentManager.getInstrument(index);
        instrumentManager.deleteInstrument(index);
        TextUi.displayInstrumentDeleted(instrumentToDelete);
        return COMMAND_WORD;
    }
}
