package seedu.mtracker.commands;

import seedu.mtracker.asserthelpers.AssertCommandHelpers;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.util.HashMap;

public class EditInstrumentCommand extends Command {

    public static final String COMMAND_WORD = "edit";
    public static final int UNINITIALISED_INDEX = -1;
    protected int index;
    protected HashMap<String, String> editedParameters;

    public EditInstrumentCommand(HashMap<String, String> editedParameters) {
        index = UNINITIALISED_INDEX;
        this.editedParameters = editedParameters;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    @Override
    public String execute() {
        AssertCommandHelpers.assertIndexWithinBounds(instrumentManager.getSize(), index);
        Instrument instrumentBefore = instrumentManager.getInstrument(index);
        instrumentManager.editInstrument(index, editedParameters);
        Instrument instrumentAfter = instrumentManager.getInstrument(index);
        TextUi.displayEditBeforeAfter(instrumentBefore, instrumentAfter);
        return COMMAND_WORD;
    }
}
