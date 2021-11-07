package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

//@@author williamlamjy
/**
 * The custom exception class that is thrown when storage file instrument name is empty.
 */
public class InvalidEmptyNameInFileError extends Exception {

    /**
     * Returns the error message to the user stating that name in storage file is empty.
     *
     * @return A string error message that states the name in storage file is empty.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.EMPTY_NAME_IN_FILE_ERROR;
    }
}
