package seedu.mtracker.commons.error;

//@@author theodorekwok
/**
 * The custom exception class that is thrown when the index provided is out of bounds.
 */
public class InvalidBoundsError extends Exception {

    /**
     * Returns the error message to the user stating that instrument at that index does not exist.
     *
     * @return A string error message that states the instrument does not exist at that index.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_INSTRUMENT_NONEXISTENT_ERROR;
    }
}
