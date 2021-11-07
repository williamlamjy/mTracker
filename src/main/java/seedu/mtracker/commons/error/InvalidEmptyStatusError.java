package seedu.mtracker.commons.error;

//@@author kum-wh
/**
 *  * The custom exception class that is thrown when an instrument status is not provided.
 */
public class InvalidEmptyStatusError extends Exception {

    /**
     * Returns the error message to the user stating that done status of an instrument cannot be empty.
     *
     * @return A string error message that states done status of an instrument must be provided.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_STATUS_EDIT_EMPTY_ERROR;
    }
}
