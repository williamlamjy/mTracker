package seedu.mtracker.commons.error;

/**
 * The custom exception class that is thrown when instrument is marked done again.
 */
public class AlreadyDoneError extends Exception {

    /**
     * Returns the error message to the user stating that instrument already has a completed status.
     *
     * @return A string error message that states the instrument is already marked as completed.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INSTRUMENT_MARKED_DONE_ERROR;
    }
}
