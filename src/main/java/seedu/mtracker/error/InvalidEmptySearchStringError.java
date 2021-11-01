package seedu.mtracker.error;

public class InvalidEmptySearchStringError extends IndexOutOfBoundsException {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_NO_KEYWORD_GIVEN_ERROR;
    }
}
