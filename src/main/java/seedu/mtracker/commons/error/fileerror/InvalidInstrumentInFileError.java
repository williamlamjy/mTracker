package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

/**
 * The custom exception class that is thrown when the storage file instrument type provided is not valid.
 */
public class InvalidInstrumentInFileError extends Exception {

    /**
     * Returns the error message to the user stating that storage file instrument type is not valid.
     *
     * @return A string error message that states the storage file instrument type is not valid.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_INSTRUMENT_IN_FILE_ERROR;
    }
}
