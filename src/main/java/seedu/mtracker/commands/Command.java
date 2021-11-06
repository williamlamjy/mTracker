package seedu.mtracker.commands;

import seedu.mtracker.model.InstrumentManager;

import java.util.ArrayList;

/**
 * Responsible for all different type of user commands.
 */
public abstract class Command {

    protected InstrumentManager instrumentManager;
    protected ArrayList<String> inputParameters;

    public void setData(InstrumentManager instrumentManager) {
        this.instrumentManager = instrumentManager;
    }

    public void setParams(ArrayList<String> parameters) {
        inputParameters = parameters;
    }

    public abstract String execute();
}
