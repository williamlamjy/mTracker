package seedu.mtracker.error;

public class InvalidEmptyIndexError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_NO_INDEX_GIVEN_ERROR;
    }
}
