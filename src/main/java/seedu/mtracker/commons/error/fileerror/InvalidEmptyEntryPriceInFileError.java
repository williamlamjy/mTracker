package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

//@@author williamlamjy
/**
 * The custom exception class that is thrown when storage file forex entry price is empty.
 */
public class InvalidEmptyEntryPriceInFileError extends Exception {

    /**
     * Returns the error message to the user stating that entry price in storage file is empty.
     *
     * @return A string error message that states the entry price in storage file is empty.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.EMPTY_ENTRY_PRICE_IN_FILE_ERROR;
    }
}
