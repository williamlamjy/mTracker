package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

public class FileWriteError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.FILE_WRITE_ERROR;
    }
}
