package seedu.mtracker.error.fileerror;

import seedu.mtracker.error.ErrorMessage;

public class InvalidCurrPriceSavedInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.CURR_PRICE_FORMATTING_IN_FILE_ERROR;
    }
}
