package seedu.mtracker.commons.error;

//@@author williamlamjy
/**
 * The custom exception class that is thrown when price provided is a negative number.
 */
public class InvalidNegativePriceError extends Exception {

    /**
     * Returns the error message to the user stating that price given cannot be negative.
     *
     * @return A string error message that states the price must be a positive numbers.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_NEGATIVE_PRICE_ERROR;
    }
}
