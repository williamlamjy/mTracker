package seedu.mtracker.commons.error;

public class AlreadyDoneError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.INSTRUMENT_MARKED_DONE_ERROR;
    }
}
