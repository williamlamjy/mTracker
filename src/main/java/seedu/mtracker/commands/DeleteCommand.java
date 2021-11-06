package seedu.mtracker.commands;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

//@@author theodorekwok
/**
 * Responsible for the command that delete an instrument from the list.
 */
public class DeleteCommand extends IndexedCommand {

    public static final String COMMAND_WORD = "delete";

    public DeleteCommand() {
        index = UNINITIALISED_INDEX;
    }

    /**
     * Handles the execution of deleting an instrument from the list.
     *
     * @return The name of the command.
     */
    @Override
    public String execute() {
        Instrument instrumentToDelete = getInstrumentAtIndex();
        instrumentManager.deleteInstrument(index);
        TextUi.displayInstrumentDeleted(instrumentToDelete);
        return COMMAND_WORD;
    }
}
