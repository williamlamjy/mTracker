package seedu.mtracker.error;

public class FileLoadError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.FILE_LOAD_ERROR;
    }
}
