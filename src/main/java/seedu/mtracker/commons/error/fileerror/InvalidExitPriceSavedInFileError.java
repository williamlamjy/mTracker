package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

public class InvalidExitPriceSavedInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.EXIT_PRICE_FORMATTING_IN_FILE_ERROR;
    }
}
