package seedu.mtracker.error;

public class InvalidInstrumentInFileError extends Exception {

    @Override
    public String getMessage(){
        return ErrorMessage.INVALID_INSTRUMENT_IN_FILE_ERROR;
    }
}
