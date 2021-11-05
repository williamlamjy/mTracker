package seedu.mtracker.commons.error;

import seedu.mtracker.asserthelpers.AssertOperationHelper;

public class OperationAbortedError extends Exception {
    private static final String EDIT_PROCESS = "edit";

    private final String process;

    @Override
    public String getMessage() {
        if (process.equals(EDIT_PROCESS)) {
            return ErrorMessage.EDIT_OPERATION_ABORTED;
        }
        AssertOperationHelper.assertIsAddOperation(process);
        return ErrorMessage.ADD_OPERATION_ABORTED;
    }

    public OperationAbortedError(String process) {
        AssertOperationHelper.assertAddEditOperation(process);
        this.process = process;
    }

}
