package seedu.mtracker.error;

public abstract class ErrorMessage {

    public static final String INVALID_INSTRUMENT_GIVEN_ERROR = "Invalid Instrument given!";
    public static final String INVALID_COMMAND_GIVEN_ERROR = "Oops, I do not understand you...";

    public static void displayAddInstrumentNameError(String instrumentType) {
        System.out.println("Sorry " + instrumentType + " cannot have an empty name!");
    }

    public static void displayAddForexNameError() {
        System.out.println("Sorry forex pair codes must contain 6 letters!");
    }

    public static void displayAddInstrumentPriceError() {
        System.out.println("Sorry price value must be a positive value and cannot be empty!");
    }

    public static void displayAddInstrumentSentimentError() {
        System.out.println("Sorry sentiment cannot be empty and must be either positive, negative or neutral!");
    }

    public static void displayEmptyExpiryError() {
        System.out.println("Sorry there must be an expiry date/time for this instrument signal!");
    }

    public static void displayFileError() {
        System.out.println("Oh no! There seems to be an error loading this file");
    }
}
