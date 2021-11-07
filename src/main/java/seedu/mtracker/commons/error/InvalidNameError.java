package seedu.mtracker.commons.error;

import seedu.mtracker.console.AddForexParser;

//@@author KVignesh122
/**
 * The custom exception class that is thrown when the name of instrument provided is not valid.
 */
public class InvalidNameError extends Exception {

    private final String instrumentType;

    /**
     * Creates a new InvalidNameError instance.
     *
     * @param instrumentType The type of instrument that is throwing this error.
     */
    public InvalidNameError(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    /**
     * Returns the error message to the user stating that name given is not valid.
     *
     * @return A string error message that states the name given is not valid.
     */
    @Override
    public String getMessage() {
        if (instrumentType.equals(AddForexParser.INSTRUMENT_TYPE)) {
            return ErrorMessage.addForexNameError();
        }
        return ErrorMessage.addInstrumentNameError(instrumentType);
    }
}
