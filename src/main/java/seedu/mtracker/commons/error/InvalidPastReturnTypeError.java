package seedu.mtracker.commons.error;

/**
 * The custom exception class that is thrown when past returns provided is not a number.
 */
public class InvalidPastReturnTypeError extends Exception {

    /**
     * Returns the error message to the user stating that past returns given is not a number.
     *
     * @return A string error message that states past returns must be a numeric value.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_PAST_RETURN_TYPE_ERROR;
    }
}
