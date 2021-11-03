package seedu.mtracker.error.fileerror;

import seedu.mtracker.error.ErrorMessage;

public class InvalidExpirySavedInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.EXPIRY_FORMATTING_IN_FILE_ERROR;
    }
}
