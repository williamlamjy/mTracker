package seedu.mtracker.error.fileerror;

import seedu.mtracker.error.ErrorMessage;

public class InvalidSentimentSavedInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.SENTIMENT_FORMATTING_IN_FILE_ERROR;
    }
}
