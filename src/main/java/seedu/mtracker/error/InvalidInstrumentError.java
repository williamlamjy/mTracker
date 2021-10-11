package seedu.mtracker.error;

public class InvalidInstrumentError extends Exception {
    
    @Override
    public String getMessage() {
        return ErrorMessage.INVALID_INSTRUMENT_GIVEN_ERROR;
    }
}
