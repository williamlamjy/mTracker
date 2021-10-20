package seedu.mtracker.commands;

import seedu.mtracker.error.ErrorMessage;
import seedu.mtracker.ui.TextUi;

public class CheckOffInstrumentCommand extends Command {

    public int completedInstrumentIndex;
    public static final String COMMAND_WORD = "done";

    public CheckOffInstrumentCommand(int completedInstrumentIndex) {
        this.completedInstrumentIndex = completedInstrumentIndex;
    }

    public boolean isValidIndex(int completedInstrumentIndex) {
        boolean isPositive = completedInstrumentIndex >= 0;
        boolean isLessThanListSize = completedInstrumentIndex <= instrumentManager.getSize() - 1;
        return isPositive && isLessThanListSize;
    }

    @Override
    public String execute() {
        if (!isValidIndex(completedInstrumentIndex)) {
            ErrorMessage.displayIndexOutOfRange();
        } else {
            instrumentManager.checkOffInstrument(completedInstrumentIndex);
            TextUi.displayCheckOffInstrument(instrumentManager.getInstrument(completedInstrumentIndex));
        }
        return COMMAND_WORD;
    }
}
