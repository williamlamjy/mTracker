package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

/**
 * The custom exception class that is thrown when storage file instrument sentiment is saved wrongly.
 */
public class InvalidSentimentSavedInFileError extends Exception {

    /**
     * Returns the error message to the user stating that sentiment in storage file is not recognised.
     *
     * @return A string error message that states the sentiment in storage file is saved is invalid.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.SENTIMENT_FORMATTING_IN_FILE_ERROR;
    }
}
