package seedu.mtracker.console;

import seedu.mtracker.LogHelper;
import seedu.mtracker.asserthelpers.AssertParserHelper;
import seedu.mtracker.commands.AddCryptoCommand;
import seedu.mtracker.commands.AddEtfCommand;
import seedu.mtracker.commands.AddForexCommand;
import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.commands.AddStockCommand;
import seedu.mtracker.commons.Validate;
import seedu.mtracker.error.InvalidInstrumentError;
import seedu.mtracker.ui.TextUi;

import java.util.ArrayList;

public abstract class AddInstrumentParser extends InputParser {

    public static final int INSTRUMENT_COMMAND_INDEX = 0;

    protected static ArrayList<String> parameters;
    protected static final String WORKSPACE = AddInstrumentCommand.COMMAND_WORD;

    public void initParameters() {
        parameters = new ArrayList<>();
    }

    public ArrayList<String> getParameters() {
        return parameters;
    }

    public static String getInstrumentNameFromUser(String instrumentType) {
        TextUi.displayAddInstrumentNameInstruction(instrumentType);
        return getUserInput(WORKSPACE);
    }

    public static void addNameToParameters(String instrumentType) {
        String name;
        do {
            name = getInstrumentNameFromUser(instrumentType);
        } while (!Validate.isValidName(name, instrumentType));
        parameters.add(name);
        AssertParserHelper.assertInputNotEmpty(name);
    }

    public static String getCurrentPriceFromUser() {
        TextUi.displayAddInstrumentCurrentPriceInstruction();
        return getUserInput(WORKSPACE);
    }

    public static void addCurrentPriceToParameters() {
        String currentPrice;
        do {
            currentPrice = getCurrentPriceFromUser();
        } while (!Validate.isValidPrice(currentPrice));;
        parameters.add(currentPrice);
        AssertParserHelper.assertInputNotEmpty(currentPrice);
        AssertParserHelper.assertPriceNonNegative(currentPrice);
    }

    public static String getInstrumentSentimentFromUser() {
        TextUi.displayAddInstrumentSentimentInstruction();
        return getUserInput(WORKSPACE);
    }


    public static void addSentimentToParameters() {
        String sentiment;
        do {
            sentiment = getInstrumentSentimentFromUser();
        } while (!Validate.isValidSentiment(sentiment));
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
            logger.info(LogHelper.LOG_INVALID_INSTRUMENT);
            throw new InvalidInstrumentError();
        }
        addInstrumentParser.initParameters();
        command = addInstrumentParser.getInstrumentParameters();
        command.setParams(addInstrumentParser.getParameters());

        return command;
    }
}
