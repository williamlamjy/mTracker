package seedu.mtracker.commands;

import seedu.mtracker.asserthelpers.AssertCommandHelpers;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

public class ViewCommand extends Command {

    public static final String COMMAND_WORD = "view";
    public static final int UNINITIALISED_INDEX = -1;
    private int index;

    public ViewCommand() {
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
        Instrument instrumentToView = instrumentManager.getInstrument(index);
        TextUi.displaySpecificInstrumentView(instrumentToView);
        return COMMAND_WORD;
    }
}
