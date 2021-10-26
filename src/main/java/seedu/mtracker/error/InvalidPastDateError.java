package seedu.mtracker.error;

public class InvalidPastDateError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_PAST_DATE_GIVEN_ERROR;
    }
}
