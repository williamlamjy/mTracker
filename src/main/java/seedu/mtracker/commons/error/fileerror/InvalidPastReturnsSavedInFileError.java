package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

public class InvalidPastReturnsSavedInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.PAST_RETURNS_FORMATTING_IN_FILE_ERROR;
    }
}
