package seedu.mtracker.error;

import seedu.mtracker.asserthelpers.AssertOperationHelper;

/**
 * The custom exception class that is thrown when user aborts an add or edit process.
 */
public class OperationAbortedError extends Exception {
    private static final String EDIT_PROCESS = "edit";
    private static final String ADD_PROCESS = "add";

    private String process;

    /**
     * Creates a new OperationAbortedError instance.
     *
     * @param process The type of process is underway when the user call abort.
     */
    public OperationAbortedError(String process) {
        AssertOperationHelper.assertAddEditOperation(process);
        this.process = process;
    }

    /**
     * Returns the error message to the user stating that process has been aborted.
     *
     * @return A string error message that states process is terminated.
     */
    @Override
    public String getMessage() {
        if (process.equals(EDIT_PROCESS)) {
            return ErrorMessage.EDIT_OPERATION_ABORTED;
        }
        return ErrorMessage.ADD_OPERATION_ABORTED;
    }
}
