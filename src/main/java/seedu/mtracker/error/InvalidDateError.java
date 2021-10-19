package seedu.mtracker.error;

public class InvalidDateError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_DATE_GIVEN_ERROR;
    }
}
