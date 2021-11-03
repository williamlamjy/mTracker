package seedu.mtracker.error.fileerror;

import seedu.mtracker.error.ErrorMessage;

public class FileLoadError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.FILE_LOAD_ERROR;
    }
}
