package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

//@@author theodorekwok
/**
 * The custom exception class that is thrown when there are problems with creating or loading a storage file.
 */
public class FileLoadError extends Exception {

    /**
     * Returns the error message to the user stating that storage file load has an error.
     *
     * @return A string error message that states the storage file has a load error.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.FILE_LOAD_ERROR;
    }
}
