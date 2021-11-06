package seedu.mtracker.commons.error;

import seedu.mtracker.asserthelpers.AssertOperationHelper;

//@@author KVignesh122
/**
 * The custom exception class that is thrown when user aborts an add or edit process.
 */
public class OperationAbortedError extends Exception {
    private static final String EDIT_PROCESS = "edit";

    private final String process;

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
        AssertOperationHelper.assertIsAddOperation(process);
        return ErrorMessage.ADD_OPERATION_ABORTED;
    }
}
