package seedu.mtracker.error;

public class FileWriteError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.FILE_WRITE_ERROR;
    }
}
