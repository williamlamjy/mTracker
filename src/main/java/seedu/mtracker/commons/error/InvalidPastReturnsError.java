package seedu.mtracker.commons.error;

public class InvalidPastReturnsError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_PAST_RETURN_ERROR;
    }
}
