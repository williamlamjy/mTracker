package seedu.mtracker.commons.error;

//@@author theodorekwok
/**
 * The custom exception class that is thrown when sentiment provided is not recognised.
 */
public class InvalidSentimentError extends Exception {

    /**
     * Returns the error message to the user stating that sentiment given is not recognised.
     *
     * @return A string error message that states the sentiment given is not valid.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_SENTIMENT_ERROR;
    }
}
