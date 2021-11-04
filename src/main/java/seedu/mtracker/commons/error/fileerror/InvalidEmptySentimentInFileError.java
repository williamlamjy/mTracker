package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

public class InvalidEmptySentimentInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.EMPTY_SENTIMENT_IN_FILE_ERROR;
    }
}
