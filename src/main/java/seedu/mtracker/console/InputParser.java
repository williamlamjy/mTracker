package seedu.mtracker.console;

import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.commands.Command;
import seedu.mtracker.commands.DeleteCommand;
import seedu.mtracker.commands.DoneCommand;
import seedu.mtracker.commands.EditInstrumentCommand;
import seedu.mtracker.commands.ExitCommand;
import seedu.mtracker.commands.ListCommand;
import seedu.mtracker.commands.FindCommand;
import seedu.mtracker.commons.Validate;
import seedu.mtracker.commands.ViewCommand;
import seedu.mtracker.error.AlreadyDoneError;
import seedu.mtracker.error.InvalidBoundsError;
import seedu.mtracker.error.InvalidCommandError;
import seedu.mtracker.error.InvalidEmptyIndexError;
import seedu.mtracker.error.InvalidEmptySearchStringError;
import seedu.mtracker.error.InvalidIndexError;
import seedu.mtracker.error.InvalidInstrumentError;
import seedu.mtracker.error.OperationAbortedError;
import seedu.mtracker.LogHelper;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Logger;

public class InputParser {

    public static final String SEPARATOR = " ";
    public static final int INDEX_OFFSET = 1;
    public static final int INSTRUMENT_INDEX = 1;
    public static final int SEARCH_STR_INDEX_START = 1;
    public static final String ABORTED = "abort";

    public static final int MAIN_COMMAND_INDEX = 0;

    protected static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    protected static Scanner inputScanner;

    private int instrumentNumber;
    private String searchString;

    public InputParser() {
        inputScanner = new Scanner(System.in);
    }

    public static String getUserInput(String currentWorkspace) {
        TextUi.displayPrompter(currentWorkspace);
        return inputScanner.nextLine().trim();
    }

    public int getInstrumentNumber() {
        return instrumentNumber;
    }

    public AddInstrumentCommand getAddInstrumentParameters()
            throws InvalidInstrumentError, OperationAbortedError {
        TextUi.displayAddInstrumentFirstInstruction();
        String addInstrumentType;
        do {
            addInstrumentType = getUserInput(AddInstrumentCommand.COMMAND_WORD).toLowerCase();
            checkIfAbort(addInstrumentType, AddInstrumentCommand.COMMAND_WORD);
        } while (!Validate.isValidInstrument(addInstrumentType));
        return AddInstrumentParser.filterByInstrumentType(getCommandComponents(addInstrumentType));
    }

    public DeleteCommand getDeleteInstrumentCommand(String[] commandComponents, ArrayList<Instrument> instruments)
            throws InvalidIndexError, InvalidEmptyIndexError, InvalidBoundsError {
        DeleteCommand deleteCommand = new DeleteCommand();
        getAndValidateIndexNumber(commandComponents, instruments);
        deleteCommand.setIndex(instrumentNumber);
        return deleteCommand;
    }

    //@@author KVignesh122
    public ViewCommand getViewInstrumentCommand(String[] commandComponents, ArrayList<Instrument> instruments)
            throws InvalidIndexError, InvalidEmptyIndexError, InvalidBoundsError {
        ViewCommand viewCommand = new ViewCommand();
        getAndValidateIndexNumber(commandComponents, instruments);
        viewCommand.setIndex(instrumentNumber);
        return viewCommand;
    }

    public FindCommand getFindInstrumentsCommand(String[] commandComponents)
            throws InvalidEmptySearchStringError {
        FindCommand findCommand = new FindCommand();
        constructSearchString(commandComponents);
        findCommand.setSearchString(searchString);
        return findCommand;
    }
    //@@author

    public DoneCommand getDoneInstrumentCommand(String[] commandComponents, ArrayList<Instrument> instruments)
            throws InvalidIndexError, InvalidEmptyIndexError, InvalidBoundsError, AlreadyDoneError {
        DoneCommand doneCommand = new DoneCommand();
        getAndValidateIndexNumber(commandComponents, instruments);
        getAndValidateDoneStatus(commandComponents, instruments);
        doneCommand.setIndex(instrumentNumber);
        return doneCommand;
    }

    public HashSet<String> filterInvalidParameters(String[] parametersToEdit, HashSet<String> validAttributes) {
        HashSet<String> filteredAttributes = new HashSet<>();
        for (String param : parametersToEdit) {
            if (validAttributes.contains(param)) {
                filteredAttributes.add(param);
            } else {
                TextUi.displayEditInvalidAttribute(param);
            }
        }
        return filteredAttributes;
    }

    public HashSet<String> getParametersToEdit(HashSet<String> validAttributes)
            throws OperationAbortedError {
        String parametersToEdit = getUserInput(EditInstrumentCommand.COMMAND_WORD).toLowerCase();
        checkIfAbort(parametersToEdit, EditInstrumentCommand.COMMAND_WORD);
        String[] parameters = getCommandComponents(parametersToEdit);
        return filterInvalidParameters(parameters, validAttributes);
    }

    public EditInstrumentCommand getEditInstrumentCommand(String[] commandComponents, ArrayList<Instrument> instruments)
            throws InvalidIndexError, InvalidEmptyIndexError, InvalidBoundsError, OperationAbortedError {
        getAndValidateIndexNumber(commandComponents, instruments);
        Instrument instrumentToEdit = instruments.get(instrumentNumber);
        TextUi.displayEditInstrumentFirstInstruction(instrumentToEdit);
        HashSet<String> parametersToEdit = getParametersToEdit(instrumentToEdit.getValidAttribute());
        EditInstrumentParser editInstrumentParser = new EditInstrumentParser();
        return editInstrumentParser.getParametersToEdit(parametersToEdit, instrumentToEdit, instrumentNumber);
    }

    private void getAndValidateIndexNumber(String[] commandComponents, ArrayList<Instrument> instruments)
            throws InvalidEmptyIndexError, InvalidIndexError, InvalidBoundsError {
        getIndexNumber(commandComponents);
        Validate.validateIndexWithinBounds(instruments, instrumentNumber);
    }

    private void getAndValidateDoneStatus(String[] commandComponents, ArrayList<Instrument> instruments)
            throws AlreadyDoneError, InvalidEmptyIndexError, InvalidIndexError {
        getIndexNumber(commandComponents);
        Validate.checkIsNotDone(instruments, instrumentNumber);
    }

    public Command filterByCommandType(String[] commandComponents, ArrayList<Instrument> instruments)
            throws Exception {
        Command command;
        switch (commandComponents[MAIN_COMMAND_INDEX].toLowerCase()) {
        case ListCommand.COMMAND_WORD:
            command = new ListCommand();
            break;
        case AddInstrumentCommand.COMMAND_WORD:
            command = getAddInstrumentParameters();
            break;
        case DeleteCommand.COMMAND_WORD:
            command = getDeleteInstrumentCommand(commandComponents, instruments);
            break;
        case ViewCommand.COMMAND_WORD:
            command = getViewInstrumentCommand(commandComponents, instruments);
            break;
        case DoneCommand.COMMAND_WORD:
            command = getDoneInstrumentCommand(commandComponents, instruments);
            break;
        case EditInstrumentCommand.COMMAND_WORD:
            command = getEditInstrumentCommand(commandComponents, instruments);
            break;
        case FindCommand.COMMAND_WORD:
            command = getFindInstrumentsCommand(commandComponents);
            break;
        case ExitCommand.COMMAND_WORD:
            command = new ExitCommand();
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

    public void getIndexNumber(String[] commandComponents) throws InvalidEmptyIndexError, InvalidIndexError {
        try {
            instrumentNumber = Integer.parseInt(commandComponents[INSTRUMENT_INDEX]) - INDEX_OFFSET;
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidEmptyIndexError();
        } catch (NumberFormatException e) {
            throw new InvalidIndexError();
        }
    }

    //@@author KVignesh122
    public void constructSearchString(String[] commandComponents) throws InvalidEmptySearchStringError {
        try {
            searchString = commandComponents[SEARCH_STR_INDEX_START];
            for (int i = SEARCH_STR_INDEX_START + 1; i < commandComponents.length; i++) {
                searchString += SEPARATOR + commandComponents[i];
            }
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidEmptySearchStringError();
        }
    }

    public static void checkIfAbort(String userInput, String currentProcess)
            throws OperationAbortedError {
        if (userInput.equalsIgnoreCase(ABORTED)) {
            throw new OperationAbortedError(currentProcess);
        }
    }
    //@@author
}
