package seedu.mtracker.error;

public class InvalidSentimentGivenError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_SENTIMENT_ERROR;
    }
}
