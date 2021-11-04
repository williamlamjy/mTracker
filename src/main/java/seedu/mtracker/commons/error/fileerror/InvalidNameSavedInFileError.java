package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

public class InvalidNameSavedInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.NAME_FORMATTING_IN_FILE_ERROR;
    }
}
