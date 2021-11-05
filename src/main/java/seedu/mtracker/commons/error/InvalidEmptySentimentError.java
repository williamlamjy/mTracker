package seedu.mtracker.commons.error;

//@@author theodorekwok
public class InvalidEmptySentimentError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_SENTIMENT_EMPTY_ERROR;
    }
}
