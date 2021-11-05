package seedu.mtracker.commons.error;

//@@author theodorekwok
public class InvalidPastDateError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_PAST_DATE_GIVEN_ERROR;
    }
}
