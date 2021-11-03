package seedu.mtracker.error.fileerror;

import seedu.mtracker.error.ErrorMessage;

public class InvalidEmptyPastReturnsInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.EMPTY_PAST_RETURNS_IN_FILE_ERROR;
    }
}
