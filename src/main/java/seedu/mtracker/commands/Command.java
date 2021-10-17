package seedu.mtracker.commands;

import seedu.mtracker.filemanager.Storage;
import seedu.mtracker.instrument.InstrumentManager;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Command {

    protected InstrumentManager instrumentManager;
    protected ArrayList<String> inputParameters;
    protected Storage storage;

    public void setData(InstrumentManager instrumentManager, Storage storage) {
        this.instrumentManager = instrumentManager;
        this.storage = storage;
    }

    public void setParams(ArrayList<String> parameters) {
        inputParameters = parameters;
    }

    public abstract String execute() throws IOException;
}
