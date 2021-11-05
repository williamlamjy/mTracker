package seedu.mtracker.commons.error;

//@@author theodorekwok
public class InvalidEmptyIndexError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_NO_INDEX_GIVEN_ERROR;
    }
}
