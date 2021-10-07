package seedu.mtracker.console;

import seedu.mtracker.commands.AddHelpCommand;
import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.commands.AddStockCommand;
import seedu.mtracker.commands.Command;
import seedu.mtracker.commands.ExitCommand;
import seedu.mtracker.error.ErrorMessage;
import seedu.mtracker.ui.TextUi;

import java.util.ArrayList;

public abstract class AddInstrumentParser extends InputParser {

    public static final int INSTRUMENT_COMMAND_INDEX = 0;

    protected static final ArrayList<String> parameters = new ArrayList<>();

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

    // Todo: Create a new command to handle an unrecognised instrument type in default branch,
    // Todo: add other instrument cases. Update the command class to allow setting of parameters as its attribute
    public static AddInstrumentCommand filterByInstrumentType(String[] commandComponents) {
        AddInstrumentCommand command;
        AddInstrumentParser addInstrumentParser;
        switch (commandComponents[INSTRUMENT_COMMAND_INDEX]) {
        case AddStockCommand.COMMAND_WORD:
            addInstrumentParser = new AddStockParser();
            break;
        default:
            addInstrumentParser = new AddInvalidInstrumentParser();
            break;
        }
        command = addInstrumentParser.getInstrumentParameters();
        command.setParams(addInstrumentParser.getParameters());

        return command;
    }
}
