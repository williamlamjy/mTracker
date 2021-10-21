package seedu.mtracker.commands;

import seedu.mtracker.asserthelpers.AssertCommandHelpers;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

public class DoneCommand extends Command {

    public static final int UNINITIALISED_INDEX = -1;
    public static final String COMMAND_WORD = "done";
    private int index;

    public DoneCommand() {
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
        Instrument instrumentToComplete = instrumentManager.getInstrument(index);
        instrumentManager.doneInstrument(index);
        TextUi.displayDoneInstrument(instrumentToComplete);
        return COMMAND_WORD;
    }
}
