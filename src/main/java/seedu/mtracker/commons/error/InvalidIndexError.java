package seedu.mtracker.commons.error;

/**
 * The custom exception class that is thrown when the index provided is not a number.
 */
public class InvalidIndexError extends Exception {

    /**
     * Returns the error message to the user stating that index given is not valid.
     *
     * @return A string error message that states the index given is not valid.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_INDEX_GIVEN_ERROR;
    }
}
