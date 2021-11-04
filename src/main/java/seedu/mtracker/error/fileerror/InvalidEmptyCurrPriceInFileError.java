package seedu.mtracker.error.fileerror;

import seedu.mtracker.error.ErrorMessage;

/**
 * The custom exception class that is thrown when storage file instrument current price is empty.
 */
public class InvalidEmptyCurrPriceInFileError extends Exception {

    /**
     * Returns the error message to the user stating that current price in storage file is empty.
     *
     * @return A string error message that states the current price in storage file is empty.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.EMPTY_CURR_PRICE_IN_FILE_ERROR;
    }
}
