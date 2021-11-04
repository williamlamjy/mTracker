package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

public class InvalidCurrPriceSavedInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.CURR_PRICE_FORMATTING_IN_FILE_ERROR;
    }
}
