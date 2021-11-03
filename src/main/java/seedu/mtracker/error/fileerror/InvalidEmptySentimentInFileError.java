package seedu.mtracker.error.fileerror;

import seedu.mtracker.error.ErrorMessage;

public class InvalidEmptySentimentInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.EMPTY_SENTIMENT_IN_FILE_ERROR;
    }
}
