package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

//@@author williamlamjy
/**
 * The custom exception class that is thrown when storage file instrument past returns is not valid or saved wrongly.
 */
public class InvalidPastReturnsSavedInFileError extends Exception {

    /**
     * Returns the error message to the user stating that past returns in storage file is invalid.
     *
     * @return A string error message that states the past returns in storage file is in the wrong format.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.PAST_RETURNS_FORMATTING_IN_FILE_ERROR;
    }
}
