package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

/**
 * The custom exception class that is thrown when storage file instrument status is empty.
 */
public class InvalidEmptyStatusInFileError extends Exception {

    /**
     * Returns the error message to the user stating that status in storage file is empty.
     *
     * @return A string error message that states the status in storage file is empty.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.EMPTY_STATUS_IN_FILE_ERROR;
    }
}
