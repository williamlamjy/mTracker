package seedu.mtracker.error;

public abstract class ErrorMessage {

    public static final String INVALID_INSTRUMENT_GIVEN_ERROR = "Invalid Instrument given!";
    public static final String INVALID_COMMAND_GIVEN_ERROR = "Oops, I do not understand you...";
    public static final String INVALID_INDEX_GIVEN_ERROR = "Oops an invalid index is given. "
            + "Please provide an acceptable index number between 1 and 2147483647";
    public static final String INVALID_NO_INDEX_GIVEN_ERROR = "Oops no index given. "
            + "Please provide an acceptable index number between 1 and 2147483647";
    public static final String INVALID_INSTRUMENT_NONEXISTENT_ERROR = "Oops instrument does not exist at that index";
    public static final String INVALID_INSTRUMENT_IN_FILE_ERROR = "Oops, it appears that the incorrect instrument"
            + "type is provided in the mTracker.txt file";
    public static final String INVALID_NO_KEYWORD_GIVEN_ERROR = "Oops please input a search"
            + " keyword after 'find' command.";

    public static final String FILE_LOAD_ERROR = "Oh no! There seems to be an error loading this file";
    public static final String FILE_TAMPERED_ERROR = "Oh no! Looks like file has been tampered, aborting load file";

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

    public static void displayWriteToFileError() {
        System.out.println("Oh no! There seems to be an error writing to the file");
    }

    public static void displayEditNameError() {
        System.out.println("Name entered is invalid. Ignoring edit for Name");
    }

    public static void displayEditPriceError() {
        System.out.println("Price entered is invalid. Ignoring edit for Price");
    }

    public static void displayEditSentimentError() {
        System.out.println("Sentiment entered is invalid. Ignoring edit for Sentiments");
    }

    public static void displayEditReturnError() {
        System.out.println("Past Returns entered is invalid. Ignoring edit for Past Returns");
    }

    public static void displayPastReturnError() {
        System.out.println("Past Returns entered is invalid.");
    }
}
