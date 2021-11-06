package seedu.mtracker.commands;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.util.HashMap;

/**
 * Handles changing the parameters to the new values.
 */
public class EditInstrumentCommand extends IndexedCommand {
    public static final String COMMAND_WORD = "edit";
    protected HashMap<String, String> editedParameters;

    public EditInstrumentCommand(HashMap<String, String> editedParameters) {
        index = UNINITIALISED_INDEX;
        this.editedParameters = editedParameters;
    }

    /**
     * Handles the execution of the command,
     * which is to change parameters to new values.
     * 
     * @return name of the command.
     */
    @Override
    public String execute() {
        Instrument instrumentToEdit = getInstrumentAtIndex();
        String instrumentBefore = instrumentToEdit.getAllParams();
        instrumentManager.editInstrument(index, editedParameters);
        String instrumentAfter = instrumentToEdit.getAllParams();
        TextUi.displayEditBeforeAfter(instrumentBefore, instrumentAfter);
        return COMMAND_WORD;
    }
}
