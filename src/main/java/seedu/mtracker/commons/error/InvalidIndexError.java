package seedu.mtracker.commons.error;

public class InvalidIndexError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_INDEX_GIVEN_ERROR;
    }
}
