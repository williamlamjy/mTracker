package seedu.mtracker.commons.error;

import seedu.mtracker.console.AddForexParser;

public class InvalidNameError extends Exception {

    private final String instrumentType;

    public InvalidNameError(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    //@@author KVignesh122
    @Override
    public String getMessage() {
        if (instrumentType.equals(AddForexParser.INSTRUMENT_TYPE)) {
            return ErrorMessage.addForexNameError();
        }
        return ErrorMessage.addInstrumentNameError(instrumentType);
    }
    //@@author
}
