package seedu.mtracker.error;

public abstract class ErrorMessage {

    public static final String INVALID_INSTRUMENT_GIVEN_ERROR = "Invalid Instrument given!";
    public static final String INVALID_COMMAND_GIVEN_ERROR = "Oops, I do not understand you...";

    public static void displayAddInstrumentNameError(String instrumentType) {
        System.out.println("Sorry " + instrumentType + " cannot have an empty name!");
    }

    public static void displayAddInstrumentPriceError() {
        System.out.println("Sorry price value must be numeric and cannot be empty!");
    }

    public static void displayAddInstrumentSentimentError() {
        System.out.println("Sorry sentiment cannot be empty and must be either positive, negative or neutral");
    }

}
