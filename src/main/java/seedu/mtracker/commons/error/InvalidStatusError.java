package seedu.mtracker.commons.error;

//@@author kum-wh
public class InvalidStatusError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_STATUS_EDIT_ERROR;
    }
}
