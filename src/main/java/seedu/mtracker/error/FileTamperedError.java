package seedu.mtracker.error;

public class FileTamperedError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.FILE_TAMPERED_ERROR;
    }
}

