package seedu.mtracker.commons.error;

//@@author theodorekwok
/**
 * The custom exception class that is thrown when index is not provided.
 */
public class InvalidEmptyIndexError extends Exception {

    /**
     * Returns the error message to the user stating that index is not given.
     *
     * @return A string error message that states index must be provided.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_NO_INDEX_GIVEN_ERROR;
    }
}
