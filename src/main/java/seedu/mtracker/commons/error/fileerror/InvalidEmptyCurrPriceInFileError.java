package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

public class InvalidEmptyCurrPriceInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.EMPTY_CURR_PRICE_IN_FILE_ERROR;
    }
}
