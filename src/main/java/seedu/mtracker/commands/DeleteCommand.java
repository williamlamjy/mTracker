package seedu.mtracker.commands;

import seedu.mtracker.error.InvalidBoundsError;
import seedu.mtracker.ui.TextUi;

public class DeleteCommand extends Command {
    public static final String COMMAND_WORD = "delete";
    private int index;

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String execute() {
        try {
            instrumentManager.deleteInstrument(index);
        } catch (InvalidBoundsError e) {
            TextUi.showErrorMessage(e);
        }
        return COMMAND_WORD;
    }
}
