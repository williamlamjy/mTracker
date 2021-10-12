package seedu.mtracker.console;

import seedu.mtracker.asserthelpers.AssertParserHelper;
import seedu.mtracker.commands.AddCryptoCommand;
import seedu.mtracker.commands.AddEtfCommand;
import seedu.mtracker.commands.AddForexCommand;
import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.commands.AddStockCommand;
import seedu.mtracker.error.ErrorMessage;
import seedu.mtracker.error.InvalidInstrumentError;
import seedu.mtracker.ui.TextUi;

import java.util.ArrayList;

public abstract class AddInstrumentParser extends InputParser {

    public static final int INSTRUMENT_COMMAND_INDEX = 0;
    private static final int FX_PAIR_NAME_LENGTH = 6;

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

    public static boolean isInvalidNameCondition(String name, String instrumentType) {
        if (instrumentType.equals(AddForexParser.INSTRUMENT_TYPE)) {
            return (name.length() != FX_PAIR_NAME_LENGTH);
        }
        return name.isEmpty();
    }

    public static boolean isValidName(String name, String instrumentType) {
        boolean isValid = true;
        try {
            if (isInvalidNameCondition(name, instrumentType)) {
               throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            if (instrumentType.equals(AddForexParser.INSTRUMENT_TYPE)) {
                ErrorMessage.displayAddForexNameError();
            } else {
                ErrorMessage.displayAddInstrumentNameError(instrumentType);
            }
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
        AssertParserHelper.assertInputNotEmpty(name);
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
            ErrorMessage.displayAddInstrumentPriceError();
            isValid = false;
        }
        return isValid;
    }

    public static boolean isExpiryFilled(String expiryInput) {
        boolean isFilled = true;
        try {
            if (expiryInput.isEmpty()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            ErrorMessage.displayEmptyExpiryError();
            isFilled = false;
        }
        return isFilled;
    }

    public static void addCurrentPriceToParameters() {
        String currentPrice = getCurrentPriceFromUser();
        while (!isValidPrice(currentPrice)) {
            currentPrice = getCurrentPriceFromUser();
        }
        parameters.add(currentPrice);
        AssertParserHelper.assertInputNotEmpty(currentPrice);
        AssertParserHelper.assertPriceNonNegative(currentPrice);
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
        AssertParserHelper.assertInputNotEmpty(sentiment);
    }

    public static void getGeneralParameters(String instrumentType) {
        addNameToParameters(instrumentType);
        addCurrentPriceToParameters();
        addSentimentToParameters();
        AssertParserHelper.assertNoMissingGeneralParameters(parameters);
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
        case AddEtfCommand.COMMAND_WORD:
            addInstrumentParser = new AddEtfParser();
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
