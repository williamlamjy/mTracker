package seedu.mtracker.commons.error;

public class InvalidStatusError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_EDIT_STATUS;
    }
}
