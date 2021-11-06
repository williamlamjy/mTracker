package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

/**
 * The custom exception class that is thrown when there are problems with writing to the storage file.
 */
public class FileWriteError extends Exception {

    /**
     * Returns the error message to the user stating that writing to the storage file has an error.
     *
     * @return A string error message that states the storage file has a write error.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.FILE_WRITE_ERROR;
    }
}
