package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

//@@author williamlamjy
/**
 * The custom exception class that is thrown when storage file forex exit price is empty.
 */
public class InvalidEmptyExitPriceInFileError extends Exception {

    /**
     * Returns the error message to the user stating that exit price in storage file is empty.
     *
     * @return A string error message that states the exit price in storage file is empty.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.EMPTY_EXIT_PRICE_IN_FILE_ERROR;
    }
}
