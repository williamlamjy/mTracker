package seedu.mtracker.error;

/**
 * The custom exception class that is thrown when the command provided is invalid.
 */
public class InvalidCommandError extends Exception {

    /**
     * Returns the error message to the user stating that command given is not valid.
     *
     * @return A string error message that states the command given is not recognised.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_COMMAND_GIVEN_ERROR;
    }
}
