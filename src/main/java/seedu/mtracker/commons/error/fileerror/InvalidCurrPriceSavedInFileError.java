package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

/**
 * The custom exception class that is thrown when storage file instrument current price is saved in the wrong format.
 */
public class InvalidCurrPriceSavedInFileError extends Exception {

    /**
     * Returns the error message to the user stating that current price in storage file has formatting issues.
     *
     * @return A string error message that states the current price in storage file is stored wrongly.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.CURR_PRICE_FORMATTING_IN_FILE_ERROR;
    }
}
