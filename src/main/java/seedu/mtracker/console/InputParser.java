package seedu.mtracker.console;

import seedu.mtracker.LogHelper;
import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.commands.Command;
import seedu.mtracker.commands.DeleteCommand;
import seedu.mtracker.commands.ViewCommand;
import seedu.mtracker.commands.ListCommand;
import seedu.mtracker.commands.FindCommand;
import seedu.mtracker.commands.ExitCommand;
import seedu.mtracker.error.*;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class InputParser {

    public static final String SEPARATOR = " ";

    public static final String POSITIVE_SENTIMENT = "positive";
    public static final String NEUTRAL_SENTIMENT = "neutral";
    public static final String NEGATIVE_SENTIMENT = "negative";

    public static final int INDEX_OFFSET = 1;
    public static final int COMMAND_PARAMETER_INDEX = 1;

    protected static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static final int MAIN_COMMAND_INDEX = 0;

    protected static Scanner inputScanner;

    private int instrumentNumber;
    private String searchString;

    public InputParser() {
        inputScanner = new Scanner(System.in);
    }

    public static String getUserInput() {
        TextUi.displayPrompter();
        return inputScanner.nextLine().trim();
    }

    public int getInstrumentNumber() {
        return instrumentNumber;
    }

    public AddInstrumentCommand getAddInstrumentParameters() throws InvalidInstrumentError {
        TextUi.displayAddInstrumentFirstInstruction();
        String addInstrumentType = getUserInput();
        return AddInstrumentParser.filterByInstrumentType(getCommandComponents(addInstrumentType));
    }

    public void validateIndexWithinBounds(ArrayList<Instrument> instruments) throws InvalidBoundsError {
        boolean isNegative = instrumentNumber < 0;
        boolean isGreaterThanListSize = instrumentNumber >= instruments.size();
        if (isNegative || isGreaterThanListSize) {
            throw new InvalidBoundsError();
        }
    }

    public DeleteCommand getDeleteInstrumentCommand(String[] commandComponents, ArrayList<Instrument> instruments)
            throws InvalidIndexError, InvalidNoIndexError, InvalidBoundsError {
        DeleteCommand deleteCommand = new DeleteCommand();
        getIndexNumber(commandComponents);
        validateIndexWithinBounds(instruments);
        deleteCommand.setIndex(instrumentNumber);
        return deleteCommand;
    }

    public ViewCommand getViewInstrumentCommand(String[] commandComponents, ArrayList<Instrument> instruments) {
        ViewCommand viewCommand = new ViewCommand();
        getIndexNumber(commandComponents);
        validateIndexWithinBounds(instruments);
        viewCommand.setIndex(instrumentNumber);
        return viewCommand;
    }

    public FindCommand getFindInstrumentsCommand(String[] commandComponents)
            throws InvalidNoKeywordError {
        FindCommand findCommand = new FindCommand();
        getSearchString(commandComponents);
        findCommand.setKeyword(searchString);
        return findCommand;
    }

    public Command filterByCommandType(String[] commandComponents, ArrayList<Instrument> instruments)
            throws Exception {
        Command command;
        switch (commandComponents[MAIN_COMMAND_INDEX]) {
        case ListCommand.COMMAND_WORD:
            command = new ListCommand();
            break;
        case AddInstrumentCommand.COMMAND_WORD:
            command = getAddInstrumentParameters();
            break;
        case DeleteCommand.COMMAND_WORD:
            command = getDeleteInstrumentCommand(commandComponents, instruments);
            break;
        case ExitCommand.COMMAND_WORD:
            command = new ExitCommand();
            break;
        case ViewCommand.COMMAND_WORD:
            command = getViewInstrumentCommand(commandComponents, instruments);
            break;
        case FindCommand.COMMAND_WORD:
            command = getFindInstrumentsCommand(commandComponents);
            break;
        default:
            logger.info(LogHelper.LOG_INVALID_COMMAND);
            throw new InvalidCommandError();
        }
        return command;
    }

    public String[] getCommandComponents(String commandInput) {
        return commandInput.trim().split(SEPARATOR);
    }

    public void getIndexNumber(String[] commandComponents) {
        try {
            instrumentNumber = Integer.parseInt(commandComponents[COMMAND_PARAMETER_INDEX]) - INDEX_OFFSET;
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidNoIndexError();
        } catch (NumberFormatException e) {
            throw new InvalidIndexError();
        }
    }

    public void getSearchString(String[] commandComponents) {
        try {
            searchString = commandComponents[COMMAND_PARAMETER_INDEX];
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidNoKeywordError();
        }
    }
}
