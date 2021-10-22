package seedu.mtracker.console;

import seedu.mtracker.LogHelper;
import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.commands.DoneCommand;
import seedu.mtracker.commands.Command;
import seedu.mtracker.commands.DeleteCommand;
import seedu.mtracker.commands.ExitCommand;
import seedu.mtracker.commands.ListCommand;
import seedu.mtracker.error.InvalidBoundsError;
import seedu.mtracker.error.InvalidCommandError;
import seedu.mtracker.error.InvalidIndexError;
import seedu.mtracker.error.InvalidInstrumentError;
import seedu.mtracker.error.InvalidNoIndexError;
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
    public static final int INSTRUMENT_INDEX = 1;

    protected static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static final int MAIN_COMMAND_INDEX = 0;

    protected static Scanner inputScanner;

    private int instrumentNumber;

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
        getAndValidateIndexNumber(commandComponents, instruments);
        deleteCommand.setIndex(instrumentNumber);
        return deleteCommand;
    }

    public DoneCommand getDoneInstrumentCommand(String[] commandComponents, ArrayList<Instrument> instruments)
            throws InvalidIndexError, InvalidNoIndexError, InvalidBoundsError {
        DoneCommand doneCommand = new DoneCommand();
        getAndValidateIndexNumber(commandComponents, instruments);
        doneCommand.setIndex(instrumentNumber);
        return doneCommand;
    }

    private void getAndValidateIndexNumber(String[] commandComponents, ArrayList<Instrument> instruments) {
        getIndexNumber(commandComponents);
        validateIndexWithinBounds(instruments);
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
        case DoneCommand.COMMAND_WORD:
            command = getDoneInstrumentCommand(commandComponents, instruments);
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
            instrumentNumber = Integer.parseInt(commandComponents[INSTRUMENT_INDEX]) - INDEX_OFFSET;
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidNoIndexError();
        } catch (NumberFormatException e) {
            throw new InvalidIndexError();
        }
    }
}
