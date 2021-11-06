package seedu.mtracker.commons.error.fileerror;

import seedu.mtracker.commons.error.ErrorMessage;

/**
 * The custom exception class that is thrown when storage file instrument sentiment is empty.
 */
public class InvalidEmptySentimentInFileError extends Exception {

    /**
     * Returns the error message to the user stating that sentiment in storage file is empty.
     *
     * @return A string error message that states the sentiment in storage file is empty.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.EMPTY_SENTIMENT_IN_FILE_ERROR;
    }
}
