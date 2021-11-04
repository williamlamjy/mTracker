package seedu.mtracker.error;

//@@author KVignesh122
public class InvalidEmptyExpiryDateError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_EXPIRY_DATE_EMPTY_ERROR;
    }
}
