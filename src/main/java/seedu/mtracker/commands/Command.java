package seedu.mtracker.commands;

import seedu.mtracker.instrument.InstrumentManager;

public abstract class Command {

    protected InstrumentManager instrumentManager;

    public void setData(InstrumentManager instrumentManager) {
        this.instrumentManager = instrumentManager;
    }

    public abstract String execute();
}
