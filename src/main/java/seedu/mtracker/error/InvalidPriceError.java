package seedu.mtracker.error;

public class InvalidPriceError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_PRICE_INPUT_ERROR;
    }
}
