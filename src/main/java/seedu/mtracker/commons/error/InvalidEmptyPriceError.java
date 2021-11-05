package seedu.mtracker.commons.error;

public class InvalidEmptyPriceError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_PRICE_EMPTY_ERROR;
    }
}
