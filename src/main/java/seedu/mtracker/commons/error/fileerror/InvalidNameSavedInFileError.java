package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

//@@author williamlamjy
/**
 * The custom exception class that is thrown when storage file instrument name is not valid.
 */
public class InvalidNameSavedInFileError extends Exception {

    /**
     * Returns the error message to the user stating that name in storage file is invalid.
     *
     * @return A string error message that states the name in storage file is in the wrong format.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.NAME_FORMATTING_IN_FILE_ERROR;
    }
}
