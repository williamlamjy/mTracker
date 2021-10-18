package seedu.mtracker.commands;

import seedu.mtracker.asserthelpers.AssertCommandHelpers;
import seedu.mtracker.error.InvalidBoundsError;
import seedu.mtracker.instrument.Instrument;
import seedu.mtracker.ui.TextUi;

public class DeleteCommand extends Command {
    public static final String COMMAND_WORD = "delete";
    private int index;

    public DeleteCommand() {
        index = -1;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String execute() {
        try {
            AssertCommandHelpers.assertIndexWithinBounds(instrumentManager.getInstruments().size(), index);
            Instrument instrumentToDelete = instrumentManager.getInstrument(index);
            instrumentManager.deleteInstrument(index);
            TextUi.displayInstrumentDeletedAcknowledgement(instrumentToDelete);
        } catch (InvalidBoundsError e) {
            TextUi.showErrorMessage(e);
        }
        return COMMAND_WORD;
    }
}
