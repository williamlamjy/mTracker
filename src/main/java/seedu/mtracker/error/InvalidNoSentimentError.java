package seedu.mtracker.error;

public class InvalidNoSentimentError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_SENTIMENT_EMPTY_ERROR;
    }
}
