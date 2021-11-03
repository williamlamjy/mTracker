package seedu.mtracker.error.fileerror;

import seedu.mtracker.error.ErrorMessage;

public class InvalidPastReturnsSavedInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.PAST_RETURNS_FORMATTING_IN_FILE_ERROR;
    }
}
