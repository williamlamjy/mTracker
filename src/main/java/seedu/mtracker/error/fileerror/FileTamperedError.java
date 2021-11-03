package seedu.mtracker.error.fileerror;

import seedu.mtracker.error.ErrorMessage;

public class FileTamperedError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.FILE_TAMPERED_ERROR;
    }
}
