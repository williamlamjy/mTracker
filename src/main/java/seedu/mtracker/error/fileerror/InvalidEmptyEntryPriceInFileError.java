package seedu.mtracker.error.fileerror;

import seedu.mtracker.error.ErrorMessage;

public class InvalidEmptyEntryPriceInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.EMPTY_ENTRY_PRICE_IN_FILE_ERROR;
    }
}
