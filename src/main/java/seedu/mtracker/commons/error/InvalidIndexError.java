package seedu.mtracker.commons.error;

//@@author theodorekwok
public class InvalidIndexError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_INDEX_GIVEN_ERROR;
    }
}
