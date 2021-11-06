package seedu.mtracker.commands;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

/**
 * Responsible for the command that allow the user to view all the parameters of a specific instrument.
 */
public class ViewCommand extends IndexedCommand {

    public static final String COMMAND_WORD = "view";

    public ViewCommand() {
        index = UNINITIALISED_INDEX;
    }

    /**
     * Handles the execution of displaying all the parameters of a specific instrument.
     *
     * @return The name of the command.
     */
    @Override
    public String execute() {
        Instrument instrumentToView = getInstrumentAtIndex();
        TextUi.displaySpecificInstrumentView(instrumentToView);
        return COMMAND_WORD;
    }
}
