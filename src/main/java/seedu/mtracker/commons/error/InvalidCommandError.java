package seedu.mtracker.commons.error;

public class InvalidCommandError extends Exception {

    private static final String ABORTED = "abort";

    private final String invalidCommand;

    public InvalidCommandError(String invalidCommand) {
        this.invalidCommand = invalidCommand;
    }

    @Override
    public String getMessage() {
        if (invalidCommand.equals(ABORTED)) {
            return ErrorMessage.INVALID_ABORT_IN_MAIN_ERROR;
        }
        return ErrorMessage.INVALID_COMMAND_ERROR;
    }
}
