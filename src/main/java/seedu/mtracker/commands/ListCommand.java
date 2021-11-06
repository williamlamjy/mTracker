package seedu.mtracker.commands;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.util.ArrayList;

/**
 * Responsible for the command that shows all instruments in the list.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    /**
     * Handles the execution of listing all the instruments in the list.
     *
     * @return The name of the command.
     */
    @Override
    public String execute() {
        ArrayList<Instrument> instruments = instrumentManager.getInstruments();
        TextUi.displayAllInstruments(instruments);
        return COMMAND_WORD;
    }
}
