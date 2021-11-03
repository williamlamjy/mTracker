package seedu.mtracker.error.fileerror;

import seedu.mtracker.error.ErrorMessage;

public class InvalidExitPriceSavedInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.EXIT_PRICE_FORMATTING_IN_FILE_ERROR;
    }
}
