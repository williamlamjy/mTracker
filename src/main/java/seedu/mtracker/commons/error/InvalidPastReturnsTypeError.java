package seedu.mtracker.commons.error;

public class InvalidPastReturnsTypeError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_PAST_RETURN_TYPE_ERROR;
    }
}
