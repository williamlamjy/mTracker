package seedu.mtracker.commons.error;

//@@author theodorekwok
public class InvalidSentimentError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_SENTIMENT_ERROR;
    }
}
