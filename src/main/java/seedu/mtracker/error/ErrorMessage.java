package seedu.mtracker.error;

public abstract class ErrorMessage {

    public static String invalidInstrumentGivenError = "Invalid Instrument given!";

    public static void displayAddInstrumentNameError(String instrumentType) {
        System.out.println("Sorry " + instrumentType + " cannot have an empty name!");
    }

    public static void displayAddInstrumentCurrentPriceError() {
        System.out.println("Sorry current price cannot be empty and must be a number!");
    }

    public static void displayAddInstrumentSentimentError() {
        System.out.println("Sorry sentiment cannot be empty and must be either positive, negative or neutral");
    }

    public static void displayAddEmptyParameterError(){
        System.out.println("Sorry the following remark/expiry cannot be empty!");
    }
}
