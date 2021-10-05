package seedu.mtracker.ui;

public class TextUi {

    public static void displayAddInstrumentInstructionOne() {
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
}
