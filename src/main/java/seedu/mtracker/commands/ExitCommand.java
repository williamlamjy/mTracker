package seedu.mtracker.commands;

import seedu.mtracker.ui.TextUi;

import java.io.IOException;

public class ExitCommand extends Command {

    public static final String COMMAND_WORD = "bye";

    @Override
    public String execute() throws IOException {
        TextUi.displayExitMessage();
        return COMMAND_WORD;
    }
}
