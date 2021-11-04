package seedu.mtracker.error.fileerror;

import seedu.mtracker.error.ErrorMessage;

public class FileWriteError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.FILE_WRITE_ERROR;
    }
}
