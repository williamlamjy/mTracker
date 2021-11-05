package seedu.mtracker.commons.error;

//@@author theodorekwok
public class InvalidBoundsError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_INSTRUMENT_NONEXISTENT_ERROR;
    }
}
