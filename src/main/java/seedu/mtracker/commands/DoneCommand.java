package seedu.mtracker.commands;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

//@@author williamlamjy
/**
 * Responsible for the command that marks an instrument as done.
 */
public class DoneCommand extends IndexedCommand {

    public static final String COMMAND_WORD = "done";

    public DoneCommand() {
        index = UNINITIALISED_INDEX;
    }

    /**
     * Handles the execution of marking an instrument as done.
     *
     * @return The name of the command.
     */
    @Override
    public String execute() {
        Instrument instrumentToComplete = getInstrumentAtIndex();
        instrumentToComplete.markAsDone();
        TextUi.displayDoneInstrument(instrumentToComplete);
        return COMMAND_WORD;
    }
}
