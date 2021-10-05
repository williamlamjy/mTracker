package seedu.mtracker.commands;

import seedu.mtracker.instrument.InstrumentManager;
import seedu.mtracker.ui.TextUi;

public abstract class Command {

    protected InstrumentManager instrumentManager;
    protected TextUi textUi;

    public Command() {
    }

    public void setData() {
        this.textUi = textUi;
        this.instrumentManager = instrumentManager;
    }

    public abstract String execute();
}
