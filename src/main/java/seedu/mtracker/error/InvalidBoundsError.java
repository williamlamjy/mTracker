package seedu.mtracker.error;

public class InvalidBoundsError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_INSTRUMENT_NONEXISTENT_ERROR;
    }
}
