package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

//@@author williamlamjy
/**
 * The custom exception class that is thrown when storage file instrument expiry date is empty.
 */
public class InvalidEmptyExpiryInFileError extends Exception {

    /**
     * Returns the error message to the user stating that expiry date in storage file is empty.
     *
     * @return A string error message that states the expiry date in storage file is empty.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.EMPTY_EXPIRY_IN_FILE_ERROR;
    }
}
