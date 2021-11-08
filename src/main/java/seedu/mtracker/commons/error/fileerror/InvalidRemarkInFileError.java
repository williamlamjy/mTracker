package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

//@@author williamlamjy
/**
 * The custom exception class that is thrown when storage file instrument remark is saved in the wrong format.
 */
public class InvalidRemarkInFileError extends Exception {

    /**
     * Returns the error message to the user stating that remark in storage file is saved in the wrong format.
     *
     * @return A string error message that states the remark in storage file is saved in the wrong format.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.REMARK_FORMATTING_IN_FILE_ERROR;
    }
}
