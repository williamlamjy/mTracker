package seedu.mtracker.error;

/**
 * The custom exception class that is thrown when price provided is not a number.
 */
public class InvalidPriceError extends Exception {

    /**
     * Returns the error message to the user stating that price given is not a number.
     *
     * @return A string error message that states price must be a numeric value.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_PRICE_INPUT_ERROR;
    }
}
