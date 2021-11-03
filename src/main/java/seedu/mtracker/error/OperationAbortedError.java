package seedu.mtracker.error;

import seedu.mtracker.asserthelpers.AssertOperationHelper;

public class OperationAbortedError extends Exception {
    private final String EDIT_PROCESS = "edit";
    private final String ADD_PROCESS = "add";

    private String process;

    @Override
    public String getMessage() {
        if (process.equals(EDIT_PROCESS)) {
            return ErrorMessage.EDIT_OPERATION_ABORTED;
        }
        return ErrorMessage.ADD_OPERATION_ABORTED;
    }

    public OperationAbortedError(String process) {
        AssertOperationHelper.assertAddEditOperation(process);
        this.process = process;
    }

}
