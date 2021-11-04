package seedu.mtracker.error.fileerror;

import seedu.mtracker.error.ErrorMessage;

public class InvalidEmptyExpiryInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.EMPTY_EXPIRY_IN_FILE_ERROR;
    }
}
