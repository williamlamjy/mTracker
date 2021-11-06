package seedu.mtracker.commons.error;

/**
 * The custom exception class that is thrown when expiry date is not provided.
 */
public class InvalidEmptyExpiryDateError extends Exception {

    /**
     * Returns the error message to the user stating that date is not given.
     *
     * @return A string error message that states date must be provided.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_EXPIRY_DATE_EMPTY_ERROR;
    }
}
