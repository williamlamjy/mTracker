package seedu.mtracker.error;

/**
 * The custom exception class that is thrown when the instrument type provided is not recognised.
 */
public class InvalidInstrumentError extends Exception {

    /**
     * Returns the error message to the user stating that instrument type given is not recognised.
     *
     * @return A string error message that states the instrument type given is not valid.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_INSTRUMENT_GIVEN_ERROR;
    }
}
