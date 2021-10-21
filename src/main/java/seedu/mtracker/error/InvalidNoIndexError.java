package seedu.mtracker.error;

public class InvalidNoIndexError extends IndexOutOfBoundsException {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_NO_INDEX_GIVEN_ERROR;
    }
}
