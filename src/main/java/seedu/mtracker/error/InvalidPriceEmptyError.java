package seedu.mtracker.error;

public class InvalidPriceEmptyError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_PRICE_EMPTY_ERROR;
    }
}
