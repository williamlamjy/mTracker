package seedu.mtracker.commands;

import seedu.mtracker.asserthelpers.AssertCommandHelpers;
import seedu.mtracker.model.Instrument;

//@@author KVignesh122
/**
 * Responsible for all commands that requires an index being input along with the command.
 */
public abstract class IndexedCommand extends Command {
    public static final int UNINITIALISED_INDEX = -1;
    protected int index;

    public void setIndex(int idx) {
        index = idx;
    }

    public int getIndex() {
        return index;
    }

    /**
     * Gets a specific instrument via its index.
     *
     * @return The instrument at a specific index.
     */
    public Instrument getInstrumentAtIndex() {
        AssertCommandHelpers.assertIndexWithinBounds(instrumentManager.getSize(), index);
        return instrumentManager.getInstrument(index);
    }
}
