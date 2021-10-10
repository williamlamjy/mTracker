package seedu.mtracker.console;

import seedu.mtracker.commands.AddCryptoCommand;
import seedu.mtracker.commands.AddForexCommand;
import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.commands.AddStockCommand;
import seedu.mtracker.error.ErrorMessage;
import seedu.mtracker.error.InvalidInstrumentError;
import seedu.mtracker.ui.TextUi;

import java.util.ArrayList;

public abstract class AddInstrumentParser extends InputParser {

    public static final int INSTRUMENT_COMMAND_INDEX = 0;

    protected static ArrayList<String> parameters;

    public void initParameters() {
        parameters = new ArrayList<>();
    }

    public ArrayList<String> getParameters() {
        return parameters;
    }

    public static String getInstrumentNameFromUser(String instrumentType) {
        TextUi.displayAddInstrumentNameInstruction(instrumentType);
        return getUserInput();
    }

    public static boolean isValidName(String name, String instrumentType) {
        boolean isValid = true;
        try {
            if (name.isEmpty()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            ErrorMessage.displayAddInstrumentNameError(instrumentType);
            isValid = false;
        }
        return isValid;
    }

    public static void addNameToParameters(String instrumentType) {
        String name = getInstrumentNameFromUser(instrumentType);
        while (!isValidName(name, instrumentType)) {
            name = getInstrumentNameFromUser(instrumentType);
        }
        parameters.add(name);
    }

    public static String getCurrentPriceFromUser() {
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
        String currentPrice = getCurrentPriceFromUser();
        while (!isValidPrice(currentPrice)) {
            currentPrice = getCurrentPriceFromUser();
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

    public abstract AddInstrumentCommand getInstrumentParameters();

    public static AddInstrumentCommand filterByInstrumentType(String[] commandComponents)
            throws InvalidInstrumentError {
        AddInstrumentCommand command;
        AddInstrumentParser addInstrumentParser;
        switch (commandComponents[INSTRUMENT_COMMAND_INDEX]) {
        case AddStockCommand.COMMAND_WORD:
            addInstrumentParser = new AddStockParser();
            break;
        case AddCryptoCommand.COMMAND_WORD:
            addInstrumentParser = new AddCryptoParser();
            break;
        case AddForexCommand.COMMAND_WORD:
            addInstrumentParser = new AddForexParser();
            break;
        default:
            throw new InvalidInstrumentError();
        }
        addInstrumentParser.initParameters();
        command = addInstrumentParser.getInstrumentParameters();
        command.setParams(addInstrumentParser.getParameters());

        return command;
    }
}
