package seedu.mtracker.ui;

import seedu.mtracker.instrument.Instrument;

public class TextUi {

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

}
