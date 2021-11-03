package seedu.mtracker.error.fileerror;

import seedu.mtracker.error.ErrorMessage;

public class InvalidEmptyNameInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.EMPTY_NAME_IN_FILE_ERROR;
    }
}
