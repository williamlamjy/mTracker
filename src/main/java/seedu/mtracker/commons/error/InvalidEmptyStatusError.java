package seedu.mtracker.commons.error;

//@@author kum-wh
public class InvalidEmptyStatusError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_STATUS_EDIT_EMPTY_ERROR;
    }
}
