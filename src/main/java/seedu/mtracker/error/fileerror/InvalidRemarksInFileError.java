package seedu.mtracker.error.fileerror;

import seedu.mtracker.error.ErrorMessage;

/**
 * The custom exception class that is thrown when storage file instrument remarks is saved wrongly.
 */
public class InvalidRemarksInFileError extends Exception {

    /**
     * Returns the error message to the user stating that remarks in storage file is saved wrongly.
     *
     * @return A string error message that states the remarks in storage file is saved in the wrong format.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.REMARKS_FORMATTING_IN_FILE_ERROR;
    }
}
