package seedu.mtracker.ui;

import seedu.mtracker.model.Instrument;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

//@@author KVignesh122
/**
 * Responsible for all interactions with the user.
 */
public class TextUi {

    private static final String INDEX_BRACKET = ") ";
    private static final String TYPE_HEADER = "Please key in the type of instrument: ";
    private static final String REMARKS_HEADER = "Remarks (optional): ";
    private static final String SENTIMENT_HEADER = "Sentiment for instrument: ";
    private static final String CURRENT_PRICE_HEADER = "Current Price: ";
    private static final String ENTRY_PRICE_HEADER = "Entry Price: ";
    private static final String EXIT_PRICE_HEADER = "Exit Price: ";
    private static final String EXPIRY_HEADER = "Expiry (YYYY-MM-DD): ";
    private static final String RETURNS_HEADER = "Past Returns (optional): ";

    private static final String LINE_DECORATOR = "_".repeat(80);
    private static final String LOGO = "            _________                      __\n"
            + "           |  _   _  |                    [  |  _\n"
            + " _ .--..--.|_/ | | \\_| .--.  ,--.   .---.  | | / ] .---.  _ .--.\n"
            + "[ `.-. .-. |   | |  [ `/'`\\]`'_\\ : / /'`\\] | '' < / /__\\\\[ `/'`\\]\n"
            + " | | | | | |  _| |_  | |    /| | |,| \\__.  | |`\\ \\| \\__., | |\n"
            + "[___||__||__]|_____|[___]   \\'-;__/'.___.'[__|  \\_]'.__.'[___]\n";
    private static final String BYE_LOGO = " ______            _______  _\n"
            + "(  ___ \\ |\\     /|(  ____ \\( )\n"
            + "| (   ) )( \\   / )| (    \\/| |\n"
            + "| (__/ /  \\ (_) / | (__    | |\n"
            + "|  __ (    \\   /  |  __)   | |\n"
            + "| (  \\ \\    ) (   | (      (_)\n"
            + "| )___) )   | |   | (____/| _\n"
            + "|/ \\___/    \\_/   (_______/(_)";

    private static final String TAB = "\t";

    private static final String EDIT_NAME_MESSAGE = "Enter new name:";
    private static final String EDIT_CURRENT_PRICE_MESSAGE = "Enter new Current price:";
    private static final String EDIT_SENTIMENT_MESSAGE = "Enter new Sentiment:";
    private static final String EDIT_REMARKS_MESSAGE = "Enter new Remarks:";
    private static final String EDIT_RETURN_MESSAGE = "Enter new Past Returns:";
    private static final String EDIT_ENTRY_MESSAGE = "Enter new Entry Price:";
    private static final String EDIT_EXIT_MESSAGE = "Enter new Exit Price:";
    private static final String EDIT_EXPIRY_MESSAGE = "Enter new Expiry (YYYY-MM-DD):";
    private static final String EDIT_STATUS_MESSAGE = "Enter new Status (please enter either done or undone):";
    private static final String WATCHLIST_HEADER = "CURRENT WATCHLIST";

    private static final int NONE_FOUND = 0;

    /**
     * Displays the new instrument added along with its parameters.
     *
     * @param newInstrument The new instrument added to the list.
     */
    public static void displayInstrumentAdded(Instrument newInstrument) {
        System.out.println(TAB + newInstrument.getGeneralParams() + " - has been added to list.");
    }

    /**
     * Prompts user to enter the type of instrument being added.
     */
    public static void displayAddInstrumentFirstInstruction() {
        System.out.println(TAB + TYPE_HEADER);
    }

    /**
     * Prompts user to enter the name of the instrument being added.
     *
     * @param instrumentType The type of the instrument being added.
     */
    public static void displayAddInstrumentNameInstruction(String instrumentType) {
        System.out.println(TAB + "Name of " + instrumentType + ": ");
    }

    /**
     * Prompts user to enter the current price of the instrument being added.
     */
    public static void displayAddInstrumentCurrentPriceInstruction() {
        System.out.println(TAB + CURRENT_PRICE_HEADER);
    }

    /**
     * Prompts user to enter the sentiment of the instrument being added.
     */
    public static void displayAddInstrumentSentimentInstruction() {
        System.out.println(TAB + SENTIMENT_HEADER);
    }

    /**
     * Prompts user to enter the remarks of the instrument being added.
     */
    public static void displayAddRemarksInstruction() {
        System.out.println(TAB + REMARKS_HEADER);
    }

    /**
     * Prompts user to enter the expiry of the instrument being added.
     */
    public static void displayAddExpiryInstruction() {
        System.out.println(TAB + EXPIRY_HEADER);
    }

    /**
     * Prompts user to enter the entry price of the instrument being added.
     */
    public static void displayAddEntryPriceInstruction() {
        System.out.println(TAB + ENTRY_PRICE_HEADER);
    }

    /**
     * Prompts user to enter the exit price of the instrument being added.
     */
    public static void displayAddExitPriceInstruction() {
        System.out.println(TAB + EXIT_PRICE_HEADER);
    }

    /**
     * Prompts user to enter the past returns of the instrument being added.
     */
    public static void displayAddPastReturnsInstruction() {
        System.out.println(TAB + RETURNS_HEADER);
    }

    /**
     * Displays all the instruments and their general parameters.
     *
     * @param instruments The list containing all the instruments.
     */
    public static void displayInstruments(ArrayList<Instrument> instruments) {
        int idx = 0;
        for (Instrument instrument: instruments) {
            idx += 1;
            System.out.println(constructLineInList(idx, instrument));
        }
    }

    /**
     * Displays all the instruments and their general parameters, along with separators and header for readability.
     *
     * @param instruments The list containing all instruments.
     */
    public static void displayAllInstruments(ArrayList<Instrument> instruments) {
        System.out.println(LINE_DECORATOR);
        System.out.println(WATCHLIST_HEADER);
        displayInstruments(instruments);
        System.out.println(LINE_DECORATOR);
    }

    /**
     * Displays to user the number of instruments found or no instrument is found.
     *
     * @param numFound The number of instruments found.
     * @param searchTerm The keyword being search.
     */
    private static void displayFoundMessage(int numFound, String searchTerm) {
        if (numFound == NONE_FOUND) {
            System.out.println("There were no instruments found for search string, " + searchTerm + ".");
            return;
        }
        System.out.println("There were " + numFound + " instrument(s) found for search string, " + searchTerm + ".");
    }

    /**
     * Displays to the user the list of instruments with name containing a specific keyword.
     *
     * @param instruments The list of instruments with name containing that keyword.
     * @param searchString The keyword being used to search.
     */
    public static void displayInstrumentsFound(ArrayList<Instrument> instruments, String searchString) {
        System.out.println(LINE_DECORATOR);
        displayInstruments(instruments);
        displayFoundMessage(instruments.size(), searchString);
        System.out.println(LINE_DECORATOR);
    }

    /**
     * Concatenates the instrument with its index and its general parameters.
     *
     * @param idx The index of the instrument.
     * @param instrument The instrument to be displayed.
     * @return The concatted string of index and general parameters.
     */
    private static String constructLineInList(int idx, Instrument instrument) {
        return idx + INDEX_BRACKET + instrument.getGeneralParams();
    }

    /**
     * Displays all the parameters of an instrument to the user.
     *
     * @param instrument The instrument to display to the user.
     */
    public static void displaySpecificInstrumentView(Instrument instrument) {
        System.out.println(LINE_DECORATOR);
        System.out.println(instrument.getAllParams());
        System.out.println(LINE_DECORATOR);
    }

    /**
     * Informs the user of the instrument that has been marked as done.
     *
     * @param instrument The instrument that is marked as done.
     */
    public static void displayDoneInstrument(Instrument instrument) {
        System.out.println(TAB + "Nice! I have marked this instrument as completed:"
                + System.lineSeparator() + TAB + TAB
                + instrument.getGeneralParams());
    }

    /**
     * Informs the user that an instrument has been deleted from the list.
     *
     * @param instrument The instrument that is deleted.
     */
    public static void displayInstrumentDeleted(Instrument instrument) {
        System.out.println(LINE_DECORATOR);
        System.out.println("Noted. " + instrument.getGeneralParams() + " - removed from your watchlist");
        System.out.println(LINE_DECORATOR);
    }

    /**
     * Informs the user that the text file for saving cannot be detected and a new one will be created.
     */
    public static void displayCreateFile() {
        System.out.println("Unable to find a saved file. Creating a new one now...");
    }

    /**
     * Informs the user that a text file used for saving have been detected and its content will be read.
     */
    public static void displayLoadingFile() {
        System.out.println("Found a saved file. Loading the saved data now...");
    }

    /**
     * Displays the respective error message to the user when an error is encountered.
     *
     * @param e The error being encountered.
     */
    public static void showErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    /**
     * Informs the user that an instrument in the text file is corrupted and will not be read from the file.
     *
     * @param idx The index of the instrument.
     */
    public static void ignoreCorruptedInstrument(AtomicInteger idx) {
        System.out.println("Ignoring saved instrument " + idx + " as it was corrupted.");
        System.out.println(LINE_DECORATOR);
    }

    /**
     * Displays a farewell message when the user exit the program.
     */
    public static void displayExitMessage() {
        System.out.println(BYE_LOGO);
        System.out.println("Thank you for using mTracker.\n"
                + "MAY THE MARKETS BE WITH YOU!!!");
    }

    /**
     * Displays to the user the current workspace the user is in.
     *
     * @param workspace The current workspace the user is in.
     */
    public static void displayPrompter(String workspace) {
        String prompter = "mTracker$" + workspace + "> ";
        System.out.print(prompter);
    }

    /**
     * Prompts the user to enter the parameters to edit.
     *
     * @param instrument The instrument being edited.
     */
    public static void displayEditInstrumentFirstInstruction(Instrument instrument) {
        System.out.println(TAB + "Please enter one or more " + instrument.getType()
                + " parameters to edit separated by spaces only." + System.lineSeparator()
                + TAB + instrument.editParameterInstructions());
    }

    /**
     * Informs the user that a certain input parameters is invalid and will not be processed.
     *
     * @param inputAttribute The input parameters that is invalid.
     */
    public static void displayEditInvalidAttribute(String inputAttribute) {
        System.out.println(inputAttribute + " is an invalid attribute of this instrument and will be ignored.");
    }

    /**
     * Prompts the user to enter the new name.
     */
    public static void displayEditName() {
        System.out.println(TAB + EDIT_NAME_MESSAGE);
    }

    /**
     * Prompts the user to enter the new current price.
     */
    public static void displayEditCurrentPrice() {
        System.out.println(TAB + EDIT_CURRENT_PRICE_MESSAGE);
    }

    /**
     * Prompts the user to enter the new sentiment value.
     */
    public static void displayEditSentiment() {
        System.out.println(TAB + EDIT_SENTIMENT_MESSAGE);
    }

    /**
     * Prompts the user to enter the new remarks.
     */
    public static void displayEditRemark() {
        System.out.println(TAB + EDIT_REMARKS_MESSAGE);
    }

    /**
     * Prompts the user to enter the new past return value.
     */
    public static void displayEditReturn() {
        System.out.println(TAB + EDIT_RETURN_MESSAGE);
    }

    /**
     * Prompts the user to enter the new entry price.
     */
    public static void displayEditEntryPrice() {
        System.out.println(TAB + EDIT_ENTRY_MESSAGE);
    }

    /**
     * Prompts the user to enter the new exit price.
     */
    public static void displayEditExitPrice() {
        System.out.println(TAB + EDIT_EXIT_MESSAGE);
    }

    /**
     * Prompts the user to enter the new expiry value.
     */
    public static void displayEditExpiry() {
        System.out.println(TAB + EDIT_EXPIRY_MESSAGE);
    }

    /**
     * Prompts the user to enter the new done status.
     */
    public static void displayEditStatus() {
        System.out.println(TAB + EDIT_STATUS_MESSAGE);
    }

    /**
     * Displays the parameters of the instrument before and after editing.
     *
     * @param beforeEdit The parameters of the instrument before editing.
     * @param afterEdit The parameters of the instrument after editing.
     */
    public static void displayEditChanges(String beforeEdit, String afterEdit) {
        System.out.println(LINE_DECORATOR);
        System.out.println("Before:");
        System.out.println(beforeEdit);
        System.out.println(LINE_DECORATOR);
        System.out.println("Changed To:");
        System.out.println(afterEdit);
        System.out.println(LINE_DECORATOR);
    }

    /**
     * Displays the parameters of the instrument before and after editing if changes were made,
     * else display that no changes were made.
     *
     * @param beforeEdit The parameters of the instrument before editing.
     * @param afterEdit The parameters of the instrument after editing.
     */
    public static void displayEditBeforeAfter(String beforeEdit, String afterEdit) {
        if (beforeEdit.equals(afterEdit)) {
            displayEditNoChange();
        } else {
            displayEditChanges(beforeEdit, afterEdit);
        }
    }

    /**
     * Informs the user no changes were made to if no changes were made in the edit function.
     */
    public static void displayEditNoChange() {
        System.out.println("No changes to instrument was made.");
    }

    /**
     * Displays the message that greet the user on start up.
     */
    public static void greetAtStartUp() {
        System.out.println(LINE_DECORATOR);
        System.out.println(LOGO);
        System.out.println("Hello! I am mTracker, your personal assistant bot that\n"
                + "helps you keep track of the markets.\nWhat should I do for you now?");
        System.out.println(LINE_DECORATOR);
    }
}
