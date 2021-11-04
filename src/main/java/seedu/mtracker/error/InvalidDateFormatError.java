package seedu.mtracker.error;

/**
 * The custom exception class that is thrown when the date provided is invalid.
 */
public class InvalidDateFormatError extends Exception {

    /**
     * Returns the error message to the user stating that date given is in the wrong format.
     *
     * @return A string error message that states the date given is in the wrong format.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_DATE_FORMAT_ERROR;
    }
}
