package seedu.mtracker.error;

public class OperationAbortedError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.ADD_OPERATION_ABORTED;
    }
}
