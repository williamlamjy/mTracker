package seedu.mtracker.commons.error;

//@@author theodorekwok
public class InvalidPriceError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_PRICE_INPUT_ERROR;
    }
}
