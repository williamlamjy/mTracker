package seedu.mtracker.ui;

import seedu.mtracker.model.Instrument;

import java.util.ArrayList;

public class TextUi {
    protected static final String LINE_DECORATOR = "_".repeat(80);
    private static final String CONSOLE_PROMPTER = "mTracker$> ";
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
    public static final String INDEX_BRACKET = ") ";

    private static final String TYPE_HEADER = "Please key in the type of instrument: ";
    private static final String CURRENT_PRICE_HEADER = "Current Price: ";
    private static final String SENTIMENT_HEADER = "Sentiment for instrument: ";
    private static final String EXPIRY_HEADER = "Expiry: ";
    private static final String REMARKS_HEADER = "Remarks (optional): ";
    private static final String ENTRY_PRICE_HEADER = "Entry Price: ";
    private static final String EXIT_PRICE_HEADER = "Exit Price: ";
    private static final String RETURNS_HEADER = "Past Returns (optional): ";
    private static final String EDIT_NAME_MESSAGE = "name changed from ";
    private static final String EDIT_CURRENTPRICE_MESSAGE = "Current price changed from ";
    private static final String EDIT_SENTIMENT_MESSAGE = "Sentiment changed from ";
    private static final String EDIT_REMARKS_MESSAGE = "Remark changed from ";
    private static final String EDIT_RETURN_MESSAGE = "Past Returns changed from ";
    private static final String EDIT_TO_MESSAGE = " to ";

    public static void displayInstrumentAdded(Instrument newInstrument) {
        System.out.println(TAB + newInstrument.getGeneralParams() + " - has been added to list.");
    }

    public static void displayAddInstrumentFirstInstruction() {
        System.out.println(TAB + TYPE_HEADER);
    }

    public static void displayAddInstrumentNameInstruction(String instrumentType) {
        System.out.println(TAB + "Name of " + instrumentType + ": ");
    }

    public static void displayAddInstrumentCurrentPriceInstruction() {
        System.out.println(TAB + CURRENT_PRICE_HEADER);
    }

    public static void displayAddInstrumentSentimentInstruction() {
        System.out.println(TAB + SENTIMENT_HEADER);
    }

    public static void displayAddRemarksInstruction() {
        System.out.println(TAB + REMARKS_HEADER);
    }

    public static void displayAddExpiryInstruction() {
        System.out.println(TAB + EXPIRY_HEADER);
    }

    public static void displayAddEntryPriceInstruction() {
        System.out.println(TAB + ENTRY_PRICE_HEADER);
    }

    public static void displayAddExitPriceInstruction() {
        System.out.println(TAB + EXIT_PRICE_HEADER);
    }

    public static void displayAddPastReturnsInstruction() {
        System.out.println(TAB + RETURNS_HEADER);
    }

    public static void displayAllInstruments(ArrayList<Instrument> instruments) {
        System.out.println(LINE_DECORATOR);
        int idx = 0;
        for (Instrument instrument: instruments) {
            idx += 1;
            System.out.println(constructLineInList(idx, instrument));
        }
        System.out.println(LINE_DECORATOR);
    }

    private static String constructLineInList(int idx, Instrument instrument) {
        return idx + INDEX_BRACKET + instrument.getGeneralParams();
    }

    public static void displaySpecificInstrumentView(Instrument instrument) {
        System.out.println(LINE_DECORATOR);
        System.out.println(instrument.getAllParams());
        System.out.println(LINE_DECORATOR);
    }

    public static void displayDoneInstrument(Instrument instrument) {
        System.out.println(TAB + "Nice! I have marked this instrument as completed:"
                + System.lineSeparator() + TAB + TAB
                + instrument.getGeneralParams());
    }

    public static void displayInstrumentDeleted(Instrument instrument) {
        System.out.println(LINE_DECORATOR);
        System.out.println("Noted. " + instrument.getGeneralParams() + " - removed from your watchlist");
        System.out.println(LINE_DECORATOR);
    }

    public static void displayCreateFile() {
        System.out.println("Unable to find a saved file. Creating a new one now...");
    }

    public static void displayLoadingFile() {
        System.out.println("Found a saved file. Loading the saved data now...");
    }

    public static void showErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void displayExitMessage() {
        System.out.println(BYE_LOGO);
        System.out.println("Thank you for using mTracker.\n"
                + "☻ MAY THE MARKETS BE WITH YOU!!! ᕦ(ò_óˇ)ᕤ");
    }

    public static void displayPrompter() {
        System.out.print(CONSOLE_PROMPTER);
    }

    public static void displayEditInstrumentFirstInstruction(Instrument instrument) {
        System.out.println("Please enter one or more " + instrument.getType()
                + " parameters to edit." + System.lineSeparator()
                + instrument.getAllParams());
    }

    public static void displayEditName(String previousName, String newName) {
        System.out.println(EDIT_NAME_MESSAGE + previousName + EDIT_TO_MESSAGE + newName);
    }

    public static void displayEditCurrentPrice(String previousPrice, String newPrice) {
        System.out.println(EDIT_CURRENTPRICE_MESSAGE + previousPrice + EDIT_TO_MESSAGE + newPrice);
    }

    public static void displayEditSentiment(String previousSentiment, String newSentiment) {
        System.out.println(EDIT_SENTIMENT_MESSAGE + previousSentiment + EDIT_TO_MESSAGE + newSentiment);
    }

    public static void displayEditRemark(String previousRemark, String newRemark) {
        System.out.println(EDIT_REMARKS_MESSAGE + previousRemark + EDIT_TO_MESSAGE + newRemark);
    }

    public static void displayEditReturn(String previousReturn, String newReturn) {
        System.out.println(EDIT_RETURN_MESSAGE + previousReturn + EDIT_TO_MESSAGE + newReturn);
    }

    public static void greetAtStartUp() {
        System.out.println(LINE_DECORATOR);
        System.out.println(LOGO);
        System.out.println("Hello! I am mTracker, your personal assistant bot that\n"
                + "helps you keep track of the markets.\nWhat should I do for you now? ☺");
        System.out.println(LINE_DECORATOR);
    }

}
