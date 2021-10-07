package seedu.mtracker.error;

public class InvalidInstrumentError extends Exception {
    
    @Override
    public String getMessage() {
        return ErrorMessage.invalidInstrumentGivenError;
    }
}
