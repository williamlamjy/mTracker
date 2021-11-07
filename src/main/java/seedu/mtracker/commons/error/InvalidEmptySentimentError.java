package seedu.mtracker.commons.error;

//@@author theodorekwok
/**
 * The custom exception class that is thrown when sentiment is not provided.
 */
public class InvalidEmptySentimentError extends Exception {

    /**
     * Returns the error message to the user stating that the sentiment is not given.
     *
     * @return A string error message that states sentiment must be provided.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_SENTIMENT_EMPTY_ERROR;
    }
}
