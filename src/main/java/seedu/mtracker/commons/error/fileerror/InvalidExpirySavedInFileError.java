package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

/**
 * The custom exception class that is thrown when storage file instrument expiry is not valid.
 */
public class InvalidExpirySavedInFileError extends Exception {

    /**
     * Returns the error message to the user stating that expiry in storage file is invalid.
     *
     * @return A string error message that states the expiry in storage file is in the wrong format.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.EXPIRY_FORMATTING_IN_FILE_ERROR;
    }
}
