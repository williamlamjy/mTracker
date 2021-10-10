package seedu.mtracker.error;

public class InvalidCommandError extends Exception {
    @Override
    public String getMessage() {
        return ErrorMessage.invalidCommandGivenError;
    }
}
