package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

public class InvalidRemarksInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.REMARKS_FORMATTING_IN_FILE_ERROR;
    }
}
