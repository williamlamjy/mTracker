package seedu.mtracker.error;

public class EditEmptyParameter extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.EDIT_EMPTY_ERROR;
    }
}
