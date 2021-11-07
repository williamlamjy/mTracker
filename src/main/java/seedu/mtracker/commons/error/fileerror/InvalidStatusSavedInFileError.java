package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

//@@author williamlamjy
/**
 * The custom exception class that is thrown when storage file instrument status is saved wrongly.
 */
public class InvalidStatusSavedInFileError extends Exception {

    /**
     * Returns the error message to the user stating that status in storage file is invalid.
     *
     * @return A string error message that states the status in storage file is saved is invalid.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.STATUS_FORMATTING_IN_FILE_ERROR;
    }
}
