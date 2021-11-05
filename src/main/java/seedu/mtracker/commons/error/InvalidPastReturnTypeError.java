package seedu.mtracker.commons.error;

//@@author theodorekwok
public class InvalidPastReturnTypeError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_PAST_RETURN_TYPE_ERROR;
    }
}
