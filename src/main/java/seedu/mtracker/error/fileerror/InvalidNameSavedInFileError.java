package seedu.mtracker.error.fileerror;

import seedu.mtracker.error.ErrorMessage;

public class InvalidNameSavedInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.NAME_FORMATTING_IN_FILE_ERROR;
    }
}
