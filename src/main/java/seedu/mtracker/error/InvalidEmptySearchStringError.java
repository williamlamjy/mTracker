package seedu.mtracker.error;

//@@author KVignesh122
public class InvalidEmptySearchStringError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_NO_SEARCH_STRING_GIVEN_ERROR;
    }
}
