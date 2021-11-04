package seedu.mtracker.commons.error;

public class InvalidCommandError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_COMMAND_GIVEN_ERROR;
    }
}
