package seedu.mtracker.commons.error;

//@@author KVignesh122
/**
 * The custom exception class that is thrown when search string is not provided.
 */
public class InvalidEmptySearchStringError extends Exception {

    /**
     * Returns the error message to the user stating that the search string is not given.
     *
     * @return A string error message that states search string must be provided.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_NO_SEARCH_STRING_GIVEN_ERROR;
    }
}
