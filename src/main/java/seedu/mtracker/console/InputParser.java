package seedu.mtracker.console;

import seedu.mtracker.LogHelper;
import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.commands.Command;
import seedu.mtracker.commands.DeleteCommand;
import seedu.mtracker.commands.DoneCommand;
import seedu.mtracker.commands.EditInstrumentCommand;
import seedu.mtracker.commands.ExitCommand;
import seedu.mtracker.commands.FindCommand;
import seedu.mtracker.commands.ListCommand;
import seedu.mtracker.commands.ViewCommand;
import seedu.mtracker.commons.Validate;
import seedu.mtracker.commons.error.AlreadyDoneError;
import seedu.mtracker.commons.error.EditEmptyParameterError;
import seedu.mtracker.commons.error.InvalidBoundsError;
import seedu.mtracker.commons.error.InvalidCommandError;
import seedu.mtracker.commons.error.InvalidEmptyIndexError;
import seedu.mtracker.commons.error.InvalidEmptySearchStringError;
import seedu.mtracker.commons.error.InvalidIndexError;
import seedu.mtracker.commons.error.InvalidInstrumentError;
import seedu.mtracker.commons.error.OperationAbortedError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.logging.Logger;

//@@author theodorekwok
/**
 * A class responsible for all the user main command inputs.
 */
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

    /**
     * Constructs the InputParser object and initialises it with a scanner for getting user input.
     */
    public InputParser() {
        inputScanner = new Scanner(System.in);
    }

    /**
     * Prompts the user to provide an input.
     *
     * @param currentWorkspace The current workflow the user is in.
     * @return The user input.
     */
    public static String getUserInput(String currentWorkspace) {
        TextUi.displayPrompter(currentWorkspace);
        return inputScanner.nextLine().trim();
    }

    public int getInstrumentNumber() {
        return instrumentNumber;
    }

    /**
     * Starts the add instrument workflow and prompts the user provide the type of instrument to add.
     *
     * @return A command to add a new instrument.
     * @throws InvalidInstrumentError If the user gave an invalid instrument type.
     * @throws OperationAbortedError If the user wants to abort the add instrument process.
     */
    public AddInstrumentCommand getAddInstrumentParameters()
            throws InvalidInstrumentError, OperationAbortedError {
        String addInstrumentType;
        do {
            TextUi.displayAddInstrumentFirstInstruction();
            addInstrumentType = getUserInput(AddInstrumentCommand.COMMAND_WORD).toLowerCase();
            checkIfAbort(addInstrumentType, AddInstrumentCommand.COMMAND_WORD);
        } while (!Validate.isValidInstrument(addInstrumentType));
        return AddInstrumentParser.filterByInstrumentType(getCommandComponents(addInstrumentType));
    }

    /**
     * Checks and prepares the delete command when the user wants to delete an instrument.
     *
     * @param commandComponents A string array containing the command words the user gave.
     * @param instruments The list of instruments currently in the user's watchlist.
     * @return A command to delete an instrument.
     * @throws InvalidIndexError If the user does not provide a valid number.
     * @throws InvalidEmptyIndexError If the user does not provide any number.
     * @throws InvalidBoundsError If the user gives a number that is outside the range of the instrument list.
     */
    public DeleteCommand getDeleteInstrumentCommand(String[] commandComponents, ArrayList<Instrument> instruments)
            throws InvalidIndexError, InvalidEmptyIndexError, InvalidBoundsError {
        DeleteCommand deleteCommand = new DeleteCommand();
        getAndValidateIndexNumber(commandComponents, instruments);
        deleteCommand.setIndex(instrumentNumber);
        return deleteCommand;
    }

    //@@author KVignesh122
    /**
     * Checks and prepares the view command when the user wants to view a specific instrument.
     *
     * @param commandComponents A string array containing the command words the user gave.
     * @param instruments The list of instruments currently in the user's watchlist.
     * @return A command to view an instrument.
     * @throws InvalidIndexError If the user does not provide a valid number.
     * @throws InvalidEmptyIndexError If the user does not provide any number.
     * @throws InvalidBoundsError If the user gives a number that is outside the range of the instrument list.
     */
    public ViewCommand getViewInstrumentCommand(String[] commandComponents, ArrayList<Instrument> instruments)
            throws InvalidIndexError, InvalidEmptyIndexError, InvalidBoundsError {
        ViewCommand viewCommand = new ViewCommand();
        getAndValidateIndexNumber(commandComponents, instruments);
        viewCommand.setIndex(instrumentNumber);
        return viewCommand;
    }

    /**
     * Checks and prepare the find command when a user wants to find instruments.
     *
     * @param commandComponents A string array containing the command words the user gave.
     * @return A command to find instruments.
     * @throws InvalidEmptySearchStringError If the user does not provide a search string.
     */
    public FindCommand getFindInstrumentsCommand(String[] commandComponents)
            throws InvalidEmptySearchStringError {
        FindCommand findCommand = new FindCommand();
        constructSearchString(commandComponents);
        findCommand.setSearchString(searchString);
        return findCommand;
    }
    //@@author

    /**
     * Checks and prepares the done command when the user wants to set the instrument status as done.
     *
     * @param commandComponents A string array containing the command words the user gave.
     * @param instruments The list of instruments currently in the user's watchlist.
     * @return A command to set the status of an instrument as completed.
     * @throws InvalidIndexError If the user does not provide a valid number.
     * @throws InvalidEmptyIndexError If the user does not provide any number.
     * @throws InvalidBoundsError If the user gives a number that is outside the range of the instrument list.
     * @throws AlreadyDoneError If the user tries to set the status of an already done instrument.
     */
    public DoneCommand getDoneInstrumentCommand(String[] commandComponents, ArrayList<Instrument> instruments)
            throws InvalidIndexError, InvalidEmptyIndexError, InvalidBoundsError, AlreadyDoneError {
        DoneCommand doneCommand = new DoneCommand();
        getAndValidateIndexNumber(commandComponents, instruments);
        getAndValidateDoneStatus(commandComponents, instruments);
        doneCommand.setIndex(instrumentNumber);
        return doneCommand;
    }

    /**
     * Checks and filters the user given parameters based on the instrument of interest set of valid attributes.
     *
     * @param parametersToEdit The set of parameters of the instrument the user wants to edit.
     * @param validAttributes The set of acceptable attributes of the instrument of interest.
     * @return A set containing the remaining valid parameters after filtering.
     */
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

    /**
     * Gets from the user the attributes to edit.
     *
     * @param validAttributes The set of acceptable attributes of the instrument of interest.
     * @return A set containing valid parameters.
     * @throws OperationAbortedError If the user wants to abort the edit instrument process.
     * @throws EditEmptyParameterError If the user did not provide any parameters.
     */
    public HashSet<String> getParametersToEdit(HashSet<String> validAttributes)
            throws OperationAbortedError, EditEmptyParameterError {
        String parametersToEdit = getUserInput(EditInstrumentCommand.COMMAND_WORD).toLowerCase();
        if (!Validate.isNonEmptyEditParameters(parametersToEdit)) {
            throw new EditEmptyParameterError();
        }
        checkIfAbort(parametersToEdit, EditInstrumentCommand.COMMAND_WORD);
        String[] parameters = getCommandComponents(parametersToEdit);
        return filterInvalidParameters(parameters, validAttributes);
    }

    /**
     * Checks and prepares the edit command when the user wants to edit an existing instrument.
     *
     * @param commandComponents A string array containing the command words the user gave.
     * @param instruments The list of instruments currently in the user's watchlist.
     * @return A command to edit an existing instrument.
     * @throws InvalidIndexError If the user does not provide a valid number.
     * @throws InvalidEmptyIndexError If the user does not provide any number.
     * @throws InvalidBoundsError If the user gives a number that is outside the range of the instrument list.
     * @throws OperationAbortedError If the user wants to abort the edit instrument process.
     * @throws EditEmptyParameterError If the user did not provide any parameters.
     */
    public EditInstrumentCommand getEditInstrumentCommand(String[] commandComponents, ArrayList<Instrument> instruments)
            throws InvalidIndexError, InvalidEmptyIndexError, InvalidBoundsError,
            OperationAbortedError, EditEmptyParameterError {
        getAndValidateIndexNumber(commandComponents, instruments);
        Instrument instrumentToEdit = instruments.get(instrumentNumber);
        TextUi.displayEditInstrumentFirstInstruction(instrumentToEdit);
        HashSet<String> parametersToEdit = getParametersToEdit(instrumentToEdit.getValidAttribute());
        EditInstrumentParser editInstrumentParser = new EditInstrumentParser();
        return editInstrumentParser.createEditCommand(parametersToEdit, instrumentToEdit, instrumentNumber);
    }

    /**
     * Checks if the index number provided is valid.
     *
     * @param commandComponents A string array containing the command words the user gave.
     * @param instruments The list of instruments currently in the user's watchlist.
     * @throws InvalidIndexError If the user does not provide a valid number.
     * @throws InvalidEmptyIndexError If the user does not provide any number.
     * @throws InvalidBoundsError If the user gives a number that is outside the range of the instrument list.
     */
    private void getAndValidateIndexNumber(String[] commandComponents, ArrayList<Instrument> instruments)
            throws InvalidEmptyIndexError, InvalidIndexError, InvalidBoundsError {
        getIndexNumber(commandComponents);
        Validate.validateIndexWithinBounds(instruments, instrumentNumber);
    }

    /**
     * Checks if the instrument is already done.
     *
     * @param commandComponents A string array containing the command words the user gave.
     * @param instruments The list of instruments currently in the user's watchlist.
     * @throws AlreadyDoneError If the user tries to set the status of an already done instrument.
     * @throws InvalidIndexError If the user does not provide a valid number.
     * @throws InvalidEmptyIndexError If the user does not provide any number.
     */
    private void getAndValidateDoneStatus(String[] commandComponents, ArrayList<Instrument> instruments)
            throws AlreadyDoneError, InvalidEmptyIndexError, InvalidIndexError {
        getIndexNumber(commandComponents);
        Validate.checkIsNotDone(instruments, instrumentNumber);
    }

    //@@author theodorekwok
    /**
     * Filters and returns the command type based on the user input.
     *
     * @param commandComponents A string array containing the command words the user gave.
     * @param instruments The list of instruments currently in the user's watchlist.
     * @return The command the user wants to execute.
     * @throws Exception If any of the user's addition or lack of inputs violates the command requirements.
     */
    public Command filterByCommandType(String[] commandComponents, ArrayList<Instrument> instruments)
            throws Exception {
        Command command;
        String commandGiven = commandComponents[MAIN_COMMAND_INDEX].toLowerCase();
        switch (commandGiven) {
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
            throw new InvalidCommandError(commandGiven);
        }
        return command;
    }

    /**
     * Takes the user input and split it into individual words.
     * Removes any additional spaces in the front and back of the input.
     *
     * @param commandInput The user input.
     * @return A string array containing the command words the user gave.
     */
    public String[] getCommandComponents(String commandInput) {
        return commandInput.trim().split(SEPARATOR);
    }

    /**
     * Parses the user input and gets the index value.
     *
     * @param commandComponents A string array containing the command words the user gave.
     * @throws InvalidEmptyIndexError If the user does not provide any number.
     * @throws InvalidIndexError If the user does not provide a valid number.
     */
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
    /**
     * Builds the search string the user wants to use to find the instruments.
     *
     * @param commandComponents A string array containing the command words the user gave.
     * @throws InvalidEmptySearchStringError If the user does not provide a search string.
     */
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

    /**
     * Checks whether the user wants to abort either the add or edit process.
     *
     * @param userInput The user input.
     * @param currentProcess The current workflow the user is in.
     * @throws OperationAbortedError If the user wants to abort the add/edit instrument process.
     */
    public static void checkIfAbort(String userInput, String currentProcess)
            throws OperationAbortedError {
        if (userInput.equalsIgnoreCase(ABORTED)) {
            throw new OperationAbortedError(currentProcess);
        }
    }
}
