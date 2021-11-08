package seedu.mtracker.commons.error;

//@@author theodorekwok
/**
 * The custom exception class that is thrown when past return provided is not a number.
 */
public class InvalidPastReturnTypeError extends Exception {

    /**
     * Returns the error message to the user stating that past return given is not a number.
     *
     * @return A string error message that states past return must be a numeric value.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_PAST_RETURN_TYPE_ERROR;
    }
}
