package seedu.mtracker.commons.error;

/**
 * The custom exception class that is thrown when price is not provided.
 */
public class InvalidEmptyPriceError extends Exception {

    /**
     * Returns the error message to the user stating that price is not given.
     *
     * @return A string error message that states price must be provided.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_PRICE_EMPTY_ERROR;
    }
}
