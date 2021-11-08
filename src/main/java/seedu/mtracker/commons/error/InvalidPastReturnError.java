package seedu.mtracker.commons.error;

//@@author theodorekwok
/**
 * The custom exception class that is thrown when past return given is less than -100.
 */
public class InvalidPastReturnError extends Exception {

    /**
     * Returns the error message to the user stating that past return given cannot be less than -100.
     *
     * @return A string error message that states past return cannot be less than -100.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_PAST_RETURN_ERROR;
    }
}
