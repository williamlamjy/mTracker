package seedu.mtracker.console;

import seedu.mtracker.commands.AddStockCommand;
import seedu.mtracker.commands.Command;
import seedu.mtracker.commands.ExitCommand;
import seedu.mtracker.error.ErrorMessage;
import seedu.mtracker.ui.TextUi;

import java.util.ArrayList;

public abstract class AddInstrumentParser extends InputParser {

    public static final int INSTRUMENT_COMMAND_INDEX = 0;
    public static final ArrayList<String> parameters = new ArrayList<>();

    public static String getInstrumentNameFromUser(String instrumentType) {
        TextUi.displayAddInstrumentNameInstruction(instrumentType);
        return getUserInput();
    }

    public static void addNameToParameters(String instrumentType) {
        String name = getInstrumentNameFromUser(instrumentType);
        while (name.equals(EMPTY_STRING)) {
            ErrorMessage.displayAddInstrumentNameError(instrumentType);
            name = getInstrumentNameFromUser(instrumentType);
        }
        parameters.add(name);
    }

    public static String getInstrumentCurrentPriceFromUser() {
        TextUi.displayAddInstrumentCurrentPriceInstruction();
        return getUserInput();
    }

    public static boolean isValidPrice(String currentPrice) {
        boolean isValid = true;
        try {
            Double.parseDouble(currentPrice);
        } catch (NumberFormatException e) {
            ErrorMessage.displayAddInstrumentCurrentPriceError();
            isValid = false;
        }
        return isValid;
    }

    public static void addCurrentPriceToParameters() {
        String currentPrice = getInstrumentCurrentPriceFromUser();
        while (!isValidPrice(currentPrice)) {
            currentPrice = getInstrumentCurrentPriceFromUser();
        }
        parameters.add(currentPrice);
    }

    public static String getInstrumentSentimentFromUser() {
        TextUi.displayAddInstrumentSentimentInstruction();
        return getUserInput();
    }

    public static boolean isValidSentiment(String sentiment) {
        boolean isValidPositiveSentiment = sentiment.equals(POSITIVE_SENTIMENT);
        boolean isValidNegativeSentiment = sentiment.equals(NEGATIVE_SENTIMENT);
        boolean isValidNeutralSentiment = sentiment.equals(NEUTRAL_SENTIMENT);
        if (!isValidPositiveSentiment && !isValidNeutralSentiment && !isValidNegativeSentiment) {
            ErrorMessage.displayAddInstrumentSentimentError();
            return false;
        }

        return true;
    }

    public static void addSentimentToParameters() {
        String sentiment = getInstrumentSentimentFromUser();
        while (!isValidSentiment(sentiment)) {
            sentiment = getInstrumentSentimentFromUser();
        }
        parameters.add(sentiment);
    }

    public static void getGeneralParameters(String instrumentType) {
        addNameToParameters(instrumentType);
        addCurrentPriceToParameters();
        addSentimentToParameters();
    }

    // Todo: Create a new command to handle an unrecognised instrument type in default branch,
    // Todo: add other instrument cases. Update the command class to allow setting of parameters as its attribute
    public static Command filterByInstrumentType(String[] commandComponents) {
        Command command;
        switch (commandComponents[INSTRUMENT_COMMAND_INDEX]) {
        case AddStockCommand.COMMAND_WORD:
            AddStockParser addStockParser = new AddStockParser();
            command = addStockParser.getStockParameters();
            break;
        default:
            command = new ExitCommand();
            break;
        }

        return command;
    }
}
