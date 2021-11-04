package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

public class InvalidEmptyExitPriceInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.EMPTY_EXIT_PRICE_IN_FILE_ERROR;
    }
}
