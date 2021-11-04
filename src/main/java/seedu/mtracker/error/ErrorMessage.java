package seedu.mtracker.error;

/**
 * An ErrorMessage class that displays all the user facing errors.
 */
public abstract class ErrorMessage {

    public static final String INVALID_INSTRUMENT_GIVEN_ERROR = "Sorry instrument must be either "
            + "stock, crypto, forex or etf.";
    public static final String INVALID_COMMAND_GIVEN_ERROR = "Oops, I do not understand you...";
    public static final String INVALID_FOREX_NAME_GIVEN_ERROR = "Sorry forex pair codes must contain 6 letters! "
            + "\nNo numbers allowed. (Eg: AUDUSD, EUR/GBP, xauusd, GBPjpy, usd/sgd, etc.)";
    public static final String INVALID_PRICE_EMPTY_ERROR = "Sorry price cannot be empty.";
    public static final String INVALID_NEGATIVE_PRICE_ERROR = "Sorry price cannot be negative. "
            + "It must be a positive number.";
    public static final String INVALID_PRICE_INPUT_ERROR = "Sorry price must be a numeric value.";
    public static final String INVALID_SENTIMENT_EMPTY_ERROR = "Sorry sentiment cannot be empty. "
            + "It must be either positive, negative or neutral.";
    public static final String INVALID_SENTIMENT_ERROR = "Sorry sentiment must be either "
            + "positive, negative or neutral.";
    public static final String INVALID_PAST_RETURN_TYPE_ERROR = "Sorry, past return must be a numeric value! "
            + "Input value will be ignored.";
    public static final String INVALID_PAST_RETURN_ERROR = "Sorry, past return inserted cannot be lesser than -100."
            + " Input value will be ignored.";
    public static final String INVALID_EXPIRY_DATE_EMPTY_ERROR = "Sorry expiry date cannot be empty.";
    public static final String INVALID_PAST_DATE_GIVEN_ERROR = "Oops, expiry cannot be a date in the past.";
    public static final String INVALID_DATE_FORMAT_ERROR = "Oops, expiry given must be in YYYY-MM-DD format";
    public static final String INVALID_INDEX_GIVEN_ERROR = "Oops an invalid index is given. "
            + "\nPlease provide an acceptable index number corresponding to the instruments in the watchlist.";
    public static final String INVALID_NO_INDEX_GIVEN_ERROR = "Oops no index given. "
            + "\nPlease provide an acceptable index number corresponding to the instruments in the watchlist.";
    public static final String INVALID_INSTRUMENT_NONEXISTENT_ERROR = "Oops, instrument does not exist at that index.";
    public static final String INVALID_INSTRUMENT_IN_FILE_ERROR = "Oops, it appears that the incorrect instrument "
            + "type is provided in the mTracker.txt file";
    public static final String INVALID_NO_SEARCH_STRING_GIVEN_ERROR = "Oops, please input a search"
            + " string after 'find' command.";
    public static final String INSTRUMENT_MARKED_DONE_ERROR = "Instrument at provided index "
            + "has already been marked as completed!";
    public static final String ADD_OPERATION_ABORTED = "Addition of new instrument has been aborted! "
            + "You are in the main workspace now.";
    public static final String EDIT_OPERATION_ABORTED = "Edit process has been aborted! "
            + "You are in the main workspace now.";

    public static final String FILE_WRITE_ERROR = "Oh no! There seems to be an error writing to the file";
    public static final String FILE_LOAD_ERROR = "Oh no! There seems to be an error loading this file";
    public static final String FILE_TAMPERED_ERROR = "Oh no! Looks like file has been tampered, aborting load file";

    public static final String REMARKS_FORMATTING_IN_FILE_ERROR = "Oh no! There seems to be an error in the formatting "
            + "of the remarks entry in the file";
    public static final String EXPIRY_FORMATTING_IN_FILE_ERROR = "Oh no! There seems to be an error in the formatting "
            + "of the expiry entry in the file." + System.lineSeparator() + "Please check that it is of YYYY-MM-DD "
            + "format.";
    public static final String ENTRY_PRICE_FORMATTING_IN_FILE_ERROR = "Oh no! There seems to be an error in the "
            + "formatting of the entry price entry in the file.";
    public static final String CURR_PRICE_FORMATTING_IN_FILE_ERROR = "Oh no! There seems to be an error in the "
            + "formatting of the current price entry in the file.";
    public static final String SENTIMENT_FORMATTING_IN_FILE_ERROR = "Oh no! There seems to be an error in the "
            + "formatting of the sentiment entry in the file.";
    public static final String STATUS_FORMATTING_IN_FILE_ERROR = "Oh no! There seems to be an error in the "
            + "formatting of the status entry in the file.";
    public static final String NAME_FORMATTING_IN_FILE_ERROR = "Oh no! There seems to be an error in the formatting "
            + "of the name entry in the file.";
    public static final String EXIT_PRICE_FORMATTING_IN_FILE_ERROR = "Oh no! There seems to be an error in the "
            + "formatting of the exit price entry in the file.";
    public static final String PAST_RETURNS_FORMATTING_IN_FILE_ERROR = "Oh no! There seems to be an error in the "
            + "formatting of the past returns entry in the file.";

    public static final String EMPTY_ENTRY_PRICE_IN_FILE_ERROR = "Oh no! Looks like the entry price entry in the file"
            + " is empty.";
    public static final String EMPTY_EXIT_PRICE_IN_FILE_ERROR = "Oh no! Looks like the exit price entry in the file"
            + " is empty.";
    public static final String EMPTY_NAME_IN_FILE_ERROR = "Oh no! Looks like the name entry in the file"
            + " is empty.";
    public static final String EMPTY_SENTIMENT_IN_FILE_ERROR = "Oh no! Looks like the sentiment entry in the file"
            + " is empty.";
    public static final String EMPTY_CURR_PRICE_IN_FILE_ERROR = "Oh no! Looks like the curr price entry in the file"
            + " is empty.";
    public static final String EMPTY_STATUS_IN_FILE_ERROR = "Oh no! Looks like the status entry in the file"
            + " is empty.";
    public static final String EMPTY_EXPIRY_IN_FILE_ERROR = "Oh no! Looks like the expiry entry in the file is empty!";

    /**
     * Returns an error message when name provided is empty.
     *
     * @param instrumentType The type of instrument the user is providing a name for.
     * @return A string error message that the instrument name cannot be empty.
     */
    public static String addInstrumentNameError(String instrumentType) {
        return "Sorry " + instrumentType + " cannot have an empty name!";
    }

    /**
     * Returns a forex error message when forex name provided is in the wrong format.
     *
     * @return A string error message that the forex name is not in the right format.
     */
    public static String addForexNameError() {
        return INVALID_FOREX_NAME_GIVEN_ERROR;
    }

    public static void displayEditNameError() {
        System.out.println("Name entered is invalid. Ignoring edited Name value.");
    }

    public static void displayEditPriceError() {
        System.out.println("Price entered is invalid. Ignoring edited Price value.");
    }

    public static void displayEditSentimentError() {
        System.out.println("Sentiment entered is invalid. Ignoring edited Sentiments value.");
    }

    public static void displayEditReturnError() {
        System.out.println("Past Returns entered is invalid. Ignoring edited Past Returns value.");
    }

    public static void displayEditExpiryError() {
        System.out.println("Expiry entered is invalid. Ignoring edited Expiry value.");
    }

}
