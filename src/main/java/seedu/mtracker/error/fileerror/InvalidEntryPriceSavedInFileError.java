package seedu.mtracker.error.fileerror;

import seedu.mtracker.error.ErrorMessage;

public class InvalidEntryPriceSavedInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.ENTRY_PRICE_FORMATTING_IN_FILE_ERROR;
    }
}
