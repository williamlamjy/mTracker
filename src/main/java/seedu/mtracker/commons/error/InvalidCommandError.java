package seedu.mtracker.commons.error;

/**
 * The custom exception class that is thrown when the command provided is invalid.
 */
public class InvalidCommandError extends Exception {

    private static final String ABORTED = "abort";

    private final String invalidCommand;

    public InvalidCommandError(String invalidCommand) {
        this.invalidCommand = invalidCommand;
    }

    /**
     * Returns the error message to the user stating that command given is not valid.
     *
     * @return A string error message that states the command given is not recognised.
     */
    @Override
    public String getMessage() {
        if (invalidCommand.equals(ABORTED)) {
            return ErrorMessage.INVALID_ABORT_IN_MAIN_ERROR;
        }
        return ErrorMessage.INVALID_COMMAND_ERROR;
    }
}
