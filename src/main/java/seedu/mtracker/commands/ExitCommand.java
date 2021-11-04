package seedu.mtracker.commands;

import seedu.mtracker.ui.TextUi;

//@@author KVignesh122
public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "bye";

    @Override
    public String execute() {
        TextUi.displayExitMessage();
        return COMMAND_WORD;
    }
}
