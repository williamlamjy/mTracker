package seedu.mtracker.commands;

import seedu.mtracker.ui.TextUi;

//@@author KVignesh122
/**
 * Responsible for the command that terminiates the program.
 */
public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "bye";

    /**
     * Handles the execution of terminating the program.
     *
     * @return The name of the command.
     */
    @Override
    public String execute() {
        TextUi.displayExitMessage();
        return COMMAND_WORD;
    }
}
