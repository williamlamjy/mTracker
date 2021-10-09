package seedu.mtracker.ui;

import seedu.mtracker.instrument.Instrument;

public class TextUi {
    protected static String lineDecorator = "_".repeat(80);
    private static String logo = "            _________                      __\n"
            + "           |  _   _  |                    [  |  _\n"
            + " _ .--..--.|_/ | | \\_| .--.  ,--.   .---.  | | / ] .---.  _ .--.\n"
            + "[ `.-. .-. |   | |  [ `/'`\\]`'_\\ : / /'`\\] | '' < / /__\\\\[ `/'`\\]\n"
            + " | | | | | |  _| |_  | |    /| | |,| \\__.  | |`\\ \\| \\__., | |\n"
            + "[___||__||__]|_____|[___]   \\'-;__/'.___.'[__|  \\_]'.__.'[___]\n";


    public static String createBoxDisplay(String icon) {
        return "[" + icon + "]";
    }

    public static void displayInstrumentAdded(Instrument newInstrument) {
        System.out.println(newInstrument);
    }

    public static void displayAddInstrumentFirstInstruction() {
        System.out.println("Please key in the type of instrument: ");
    }

    public static void displayAddInstrumentNameInstruction(String instrumentType) {
        System.out.println("Name of " + instrumentType + ": ");
    }

    public static void displayAddInstrumentCurrentPriceInstruction() {
        System.out.println("Current Price: ");
    }

    public static void displayAddInstrumentSentimentInstruction() {
        System.out.println("Sentiment of security: ");
    }

    public static void displayAddRemarksInstruction() {
        System.out.println("Remarks (optional): ");
    }

    public static void displayAddExpiryInstruction() {
        System.out.println("Expiry: ");
    }

    public void showErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void greetAtStartUp() {
        System.out.println(lineDecorator);
        System.out.println(logo);
        System.out.println("Hello! I am mTracker, your personal assistant bot that\n"
                + "helps you keep track of the markets.\nWhat should I do for you now? ☺");
        System.out.println(lineDecorator);
        System.out.println(System.lineSeparator());
    }

}
