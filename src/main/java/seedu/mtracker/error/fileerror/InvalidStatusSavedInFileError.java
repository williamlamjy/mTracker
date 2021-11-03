package seedu.mtracker.error.fileerror;

import seedu.mtracker.error.ErrorMessage;

public class InvalidStatusSavedInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.STATUS_FORMATTING_IN_FILE_ERROR;
    }
}
