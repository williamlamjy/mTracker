package seedu.mtracker.commons.error;

//@@author theodorekwok
public class InvalidPastReturnError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_PAST_RETURN_ERROR;
    }
}
