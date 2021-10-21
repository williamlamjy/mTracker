package seedu.mtracker.error;

public class InvalidIndexError extends NumberFormatException {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_INDEX_GIVEN_ERROR;
    }
}
