package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

public class FileLoadError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.FILE_LOAD_ERROR;
    }
}
