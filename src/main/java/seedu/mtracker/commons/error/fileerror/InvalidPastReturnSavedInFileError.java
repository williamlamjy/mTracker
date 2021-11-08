package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

//@@author williamlamjy
/**
 * The custom exception class that is thrown when storage file instrument past return is not valid or saved wrongly.
 */
public class InvalidPastReturnSavedInFileError extends Exception {

    /**
     * Returns the error message to the user stating that past return in storage file is invalid.
     *
     * @return A string error message that states the past return in storage file is in the wrong format.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.PAST_RETURN_FORMATTING_IN_FILE_ERROR;
    }
}
