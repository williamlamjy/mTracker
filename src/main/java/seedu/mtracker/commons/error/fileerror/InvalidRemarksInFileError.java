package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

/**
 * The custom exception class that is thrown when storage file instrument remarks is saved in the wrong format.
 */
public class InvalidRemarksInFileError extends Exception {

    /**
     * Returns the error message to the user stating that remarks in storage file is saved in the wrong format.
     *
     * @return A string error message that states the remarks in storage file is saved in the wrong format.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.REMARKS_FORMATTING_IN_FILE_ERROR;
    }
}
