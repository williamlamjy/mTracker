package seedu.mtracker.commons.error;

//@@author kum-wh
/**
 *  * The custom exception class that is thrown when parameters to edit are not provided.
 */
public class EditEmptyParameterError extends Exception {

    /**
     * Returns the error message to the user stating that parameters to edit cannot be empty.
     *
     * @return A string error message that states parameters to edit must be provided.
     */
    @Override
    public String getMessage() {
        return ErrorMessage.EDIT_EMPTY_ERROR;
    }
}
