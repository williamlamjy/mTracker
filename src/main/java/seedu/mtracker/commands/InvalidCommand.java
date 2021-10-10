package seedu.mtracker.commands;

import seedu.mtracker.error.InvalidCommandError;

public class InvalidCommand extends Command {
    public static final String COMMAND_WORD = null;

    @Override
    public String execute() throws InvalidCommandError {
        throw new InvalidCommandError();
    }

    public InvalidCommand() {

    }
}
