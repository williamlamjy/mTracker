package seedu.mtracker.commands;

import seedu.mtracker.asserthelpers.AssertCommandHelpers;
import seedu.mtracker.model.Instrument;

//@@author KVignesh122
public abstract class IndexedCommand extends Command {
    public static final int UNINITIALISED_INDEX = -1;
    protected int index;

    public void setIndex(int idx) {
        index = idx;
    }

    public int getIndex() {
        return index;
    }

    public Instrument getInstrumentAtIndex() {
        AssertCommandHelpers.assertIndexWithinBounds(instrumentManager.getSize(), index);
        return instrumentManager.getInstrument(index);
    }
}
