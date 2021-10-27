package seedu.mtracker.error;

public class InvalidEmptySentimentError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_SENTIMENT_EMPTY_ERROR;
    }
}
