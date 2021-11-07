package seedu.mtracker.commons.error;

//@@author kum-wh
/**
 *  * The custom exception class that is thrown when status provided is not done or undone.
 */
public class InvalidStatusError extends Exception {

    /**
     * Returns the error message to the user stating that status entered is not a valid status.
     *
     * @return A string error message that states done status must be either done or undone.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_STATUS_EDIT_ERROR;
    }
}
