package seedu.mtracker.ui;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.model.subinstrument.Crypto;
import seedu.mtracker.model.subinstrument.Etf;
import seedu.mtracker.model.subinstrument.Forex;
import seedu.mtracker.model.subinstrument.Stock;

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
    public static final String SEMICOLON_SEP = "; ";
    public static final String INDEX_BRACKET = ") ";
    public static final String SPACE = " ";

    private static final String TYPE_HEADER = "Type: ";
    private static final String NAME_HEADER = "Name: ";
    private static final String CURRENT_PRICE_HEADER = "Current Price: ";
    private static final String SENTIMENT_HEADER = "Sentiment: ";
    protected static final String EXPIRY_HEADER = "Expiry: ";
    protected static final String REMARKS_HEADER = "Remarks: ";
    protected static final String ENTRY_PRICE_HEADER = "Entry Price: ";
    protected static final String EXIT_PRICE_HEADER = "Exit Price: ";
    protected static final String RETURNS_HEADER = "Past Returns: ";

    private static final String FOREX_TYPE = "Forex";
    private static final String CRYPTO_TYPE = "Crypto";
    private static final String ETF_TYPE = "Etf";

    public static void displayInstrumentAdded(Instrument newInstrument) {
        System.out.println(TAB + displayInstrumentGeneralView(newInstrument) + " - has been added to list.");
    }

    public static void displayAddInstrumentFirstInstruction() {
        System.out.println(TAB + "Please key in the type of instrument: ");
    }

    public static void displayAddInstrumentNameInstruction(String instrumentType) {
        System.out.println(TAB + "Name of " + instrumentType + ": ");
    }

    public static void displayAddInstrumentCurrentPriceInstruction() {
        System.out.println(TAB + CURRENT_PRICE_HEADER);
    }

    public static void displayAddInstrumentSentimentInstruction() {
        System.out.println(TAB + "Sentiment for instrument: ");
    }

    public static void displayAddRemarksInstruction() {
        System.out.println(TAB + "Remarks (optional): ");
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
        System.out.println(TAB + "Past Returns (optional): ");
    }

    // @@KVignesh122
    public static void displayAllInstruments(ArrayList<Instrument> instruments) {
        System.out.println(LINE_DECORATOR);
        int idx = 0;
        for (Instrument instrument: instruments) {
            idx += 1;
            System.out.print(idx + INDEX_BRACKET);
            System.out.println(displayInstrumentGeneralView(instrument));
        }
        System.out.println(LINE_DECORATOR);
    }

    public static String displayInstrumentGeneralView(Instrument instrument) {
        return instrument.getIcon()
                + SPACE + instrument.getName()
                + SEMICOLON_SEP + instrument.getCurrentPrice()
                + SEMICOLON_SEP + instrument.getSentiment();
    }

    public static String getAdditionalParams(Instrument instrument) {
        String type = instrument.getType();
        if (type.equals(FOREX_TYPE)) {
            return getForexAdditionalParams((Forex) instrument);
        }
        if (type.equals(CRYPTO_TYPE)) {
            return getCryptoAdditionalParams((Crypto) instrument);
        }
        if (type.equals(ETF_TYPE)) {
            return getEtfAdditionalParams((Etf) instrument);
        }
        return getStockAdditionalParams((Stock) instrument);
    }

    private static String getStockAdditionalParams(Stock instrument) {
        return REMARKS_HEADER + instrument.getRemark();
    }

    private static String getEtfAdditionalParams(Etf instrument) {
        return RETURNS_HEADER + instrument.getReturns()
                + System.lineSeparator() + REMARKS_HEADER + instrument.getRemark();
    }

    private static String getCryptoAdditionalParams(Crypto instrument) {
        return EXPIRY_HEADER + instrument.getExpiry()
                + System.lineSeparator() + REMARKS_HEADER + instrument.getRemark();
    }

    private static String getForexAdditionalParams(Forex instrument) {
        return ENTRY_PRICE_HEADER + instrument.getEntryPrice()
                + System.lineSeparator() + EXIT_PRICE_HEADER + instrument.getExitPrice()
                + System.lineSeparator() + EXPIRY_HEADER + instrument.getExpiry()
                + System.lineSeparator() + REMARKS_HEADER + instrument.getRemark();
    }

    public static void displaySpecificInstrumentView(Instrument instrument) {
        System.out.println(LINE_DECORATOR);
        System.out.println(TYPE_HEADER + instrument.getType());
        System.out.println(NAME_HEADER + instrument.getName());
        System.out.println(CURRENT_PRICE_HEADER + instrument.getCurrentPrice());
        System.out.println(SENTIMENT_HEADER + instrument.getSentiment());
        System.out.println(getAdditionalParams(instrument));
        System.out.println(LINE_DECORATOR);
    }

    // @@theodorekwok
    public static void displayInstrumentDeleted(Instrument instrument) {
        System.out.println(LINE_DECORATOR);
        System.out.println("Noted. " + displayInstrumentGeneralView(instrument) + " - removed from your watchlist");
        System.out.println(LINE_DECORATOR);
    }

    // @@williamlamjy
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

    public static void greetAtStartUp() {
        System.out.println(LINE_DECORATOR);
        System.out.println(LOGO);
        System.out.println("Hello! I am mTracker, your personal assistant bot that\n"
                + "helps you keep track of the markets.\nWhat should I do for you now? ☺");
        System.out.println(LINE_DECORATOR);
    }

}
