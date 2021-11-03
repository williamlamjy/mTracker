package seedu.mtracker.error.fileerror;

import seedu.mtracker.error.ErrorMessage;

public class InvalidRemarksInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.REMARKS_FORMATTING_IN_FILE_ERROR;
    }
}
