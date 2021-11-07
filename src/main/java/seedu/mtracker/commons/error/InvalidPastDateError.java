package seedu.mtracker.commons.error;

//@@author theodorekwok
/**
 * The custom exception class that is thrown when date provided is in the past.
 */
public class InvalidPastDateError extends Exception {

    /**
     * Returns the error message to the user stating that date given cannot be in the past.
     *
     * @return A string error message that states the date cannot be in the past.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_PAST_DATE_GIVEN_ERROR;
    }
}
