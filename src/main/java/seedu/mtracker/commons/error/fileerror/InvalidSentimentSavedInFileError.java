package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

public class InvalidSentimentSavedInFileError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.SENTIMENT_FORMATTING_IN_FILE_ERROR;
    }
}
