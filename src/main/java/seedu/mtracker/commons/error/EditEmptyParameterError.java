package seedu.mtracker.commons.error;

//@@author kum-wh

public class EditEmptyParameterError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.EDIT_EMPTY_ERROR;
    }
}
