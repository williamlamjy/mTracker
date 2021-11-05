package seedu.mtracker.console;

import seedu.mtracker.LogHelper;
import seedu.mtracker.asserthelpers.AssertParserHelper;
import seedu.mtracker.commands.AddCryptoCommand;
import seedu.mtracker.commands.AddEtfCommand;
import seedu.mtracker.commands.AddForexCommand;
import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.commands.AddStockCommand;
import seedu.mtracker.commons.Validate;
import seedu.mtracker.commons.error.InvalidInstrumentError;
import seedu.mtracker.commons.error.OperationAbortedError;
import seedu.mtracker.ui.TextUi;

import java.util.ArrayList;

/**
 * An abstract class that is responsible for parsing common parameters found in every instrument type.
 */
public abstract class AddInstrumentParser extends InputParser {

    public static final int INSTRUMENT_COMMAND_INDEX = 0;

    protected static ArrayList<String> parameters;
    protected static final String WORKSPACE = AddInstrumentCommand.COMMAND_WORD;

    /**
     * Initialises the parameters attribute as a new list.
     */
    public void initParameters() {
        parameters = new ArrayList<>();
    }

    public ArrayList<String> getParameters() {
        return parameters;
    }

    /**
     * Queries and gets instrument name from the user.
     *
     * @param instrumentType The type of instrument the user is adding.
     * @return User name input.
     */
    public static String getInstrumentNameFromUser(String instrumentType) {
        TextUi.displayAddInstrumentNameInstruction(instrumentType);
        return getUserInput(WORKSPACE);
    }

    /**
     * Gets the user instrument name input and adds it into the parameters list.
     *
     * @param instrumentType The type of instrument the user is adding.
     * @throws OperationAbortedError If the user wants to abort the add instrument process.
     */
    public static void addNameToParameters(String instrumentType) throws OperationAbortedError {
        String name;
        do {
            name = getInstrumentNameFromUser(instrumentType);
            checkIfAbort(name, WORKSPACE);
        } while (!Validate.isValidName(name, instrumentType));
        parameters.add(name);
        AssertParserHelper.assertInputNotEmpty(name);
    }

    /**
     * Queries and gets instrument current price from the user.
     *
     * @return User current price input.
     */
    public static String getCurrentPriceFromUser() {
        TextUi.displayAddInstrumentCurrentPriceInstruction();
        return getUserInput(WORKSPACE);
    }

    /**
     * Gets the user current price and adds it into the parameters list.
     *
     * @throws OperationAbortedError If the user wants to abort the add instrument process.
     */
    public static void addCurrentPriceToParameters() throws OperationAbortedError {
        String currentPrice;
        do {
            currentPrice = getCurrentPriceFromUser();
            checkIfAbort(currentPrice, WORKSPACE);
        } while (!Validate.isValidPrice(currentPrice));
        parameters.add(currentPrice);
        AssertParserHelper.assertInputNotEmpty(currentPrice);
        AssertParserHelper.assertPriceNonNegative(currentPrice);
    }

    /**
     * Queries and gets instrument sentiment from the user.
     *
     * @return User sentiment input.
     */
    public static String getInstrumentSentimentFromUser() {
        TextUi.displayAddInstrumentSentimentInstruction();
        return getUserInput(WORKSPACE);
    }

    /**
     * Gets the user sentiment input and adds it into the parameters.
     *
     * @throws OperationAbortedError If the user wants to abort the add instrument process.
     */
    public static void addSentimentToParameters() throws OperationAbortedError {
        String sentiment;
        do {
            sentiment = getInstrumentSentimentFromUser().toLowerCase();
            checkIfAbort(sentiment, WORKSPACE);
        } while (!Validate.isValidSentiment(sentiment));
        parameters.add(sentiment);
        AssertParserHelper.assertInputNotEmpty(sentiment);
    }

    /**
     * Gets from the user parameters that are required for adding any of the different instrument types.
     *
     * @param instrumentType The type of instrument the user is adding.
     * @throws OperationAbortedError If the user wants to abort the add instrument process.
     */
    public static void getGeneralParameters(String instrumentType) throws OperationAbortedError {
        addNameToParameters(instrumentType);
        addCurrentPriceToParameters();
        addSentimentToParameters();
        AssertParserHelper.assertNoMissingGeneralParameters(parameters);
    }

    /**
     * Gets from the user all parameters needed to create a new instrument.
     *
     * @return A command for adding a new instrument.
     * @throws OperationAbortedError If the user wants to abort the add instrument process.
     */
    public abstract AddInstrumentCommand getInstrumentParameters() throws OperationAbortedError;

    /**
     * Filters and starts the add instrument process based on the type of instrument the user is adding.
     * Sets up the command to be returned with the parameters filled with the user input details.
     *
     * @param commandComponents A string array containing the command words the user gave.
     * @return A command for adding a new instrument.
     * @throws InvalidInstrumentError If the user gave an invalid instrument type.
     * @throws OperationAbortedError If the user wants to abort the add instrument process.
     */
    public static AddInstrumentCommand filterByInstrumentType(String[] commandComponents)
            throws InvalidInstrumentError, OperationAbortedError {
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
