package seedu.mtracker.commons.error;

public class EditEmptyParameterError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.EDIT_EMPTY_ERROR;
    }
}
