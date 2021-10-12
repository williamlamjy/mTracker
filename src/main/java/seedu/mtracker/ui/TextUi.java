package seedu.mtracker.ui;

import seedu.mtracker.instrument.Instrument;

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

    public static String createBoxDisplay(String icon) {
        return "[" + icon + "]";
    }

    public static void displayInstrumentAdded(Instrument newInstrument) {
        System.out.println(TAB + newInstrument);
    }

    public static void displayAddInstrumentFirstInstruction() {
        System.out.println(TAB + "Please key in the type of instrument: ");
    }

    public static void displayAddInstrumentNameInstruction(String instrumentType) {
        System.out.println(TAB + "Name of " + instrumentType + ": ");
    }

    public static void displayAddInstrumentCurrentPriceInstruction() {
        System.out.println(TAB + "Current Price: ");
    }

    public static void displayAddInstrumentSentimentInstruction() {
        System.out.println(TAB + "Sentiment for instrument: ");
    }

    public static void displayAddRemarksInstruction() {
        System.out.println(TAB + "Remarks (optional): ");
    }

    public static void displayAddExpiryInstruction() {
        System.out.println(TAB + "Expiry: ");
    }

    public static void displayAddEntryPriceInstruction() {
        System.out.println(TAB + "Entry price: ");
    }

    public static void displayAddExitPriceInstruction() {
        System.out.println(TAB + "Exit price: ");
    }

    public static void displayAddPastReturnsInstruction() {
        System.out.println(TAB + "Past Returns (optional): ");
    }

    private static void displayInstrument(Instrument instrument) {
        System.out.println(LINE_DECORATOR);
        System.out.println(instrument.toList());
        System.out.println(LINE_DECORATOR);
    }

    public static void displayAllInstruments(ArrayList<Instrument> instruments) {
        instruments.stream().forEach(instrument -> displayInstrument(instrument));
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
