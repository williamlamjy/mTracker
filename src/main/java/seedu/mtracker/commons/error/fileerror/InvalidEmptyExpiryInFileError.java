package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

public class InvalidEmptyExpiryInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.EMPTY_EXPIRY_IN_FILE_ERROR;
    }
}
