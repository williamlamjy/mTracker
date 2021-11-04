package seedu.mtracker.error.fileerror;

import seedu.mtracker.error.ErrorMessage;

/**
 * The custom exception class that is thrown when storage file forex entry price is not valid.
 */
public class InvalidEntryPriceSavedInFileError extends Exception {

    /**
     * Returns the error message to the user stating that entry price in storage file is invalid.
     *
     * @return A string error message that states the entry price in storage file is in the wrong format.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.ENTRY_PRICE_FORMATTING_IN_FILE_ERROR;
    }
}
