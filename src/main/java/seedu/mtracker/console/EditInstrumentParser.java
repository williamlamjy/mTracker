package seedu.mtracker.console;

import seedu.mtracker.commands.EditInstrumentCommand;
import seedu.mtracker.commons.Validate;
import seedu.mtracker.commons.error.OperationAbortedError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Handle getting all the new values of each parameter being edited.
 */
public class EditInstrumentParser extends InputParser {

    protected static HashMap<String, String> editedParameters;

    protected static final String NAME_ATTRIBUTE = "name";
    protected static final String CURRENT_PRICE_ATTRIBUTE = "current-price";
    protected static final String SENTIMENT_ATTRIBUTE = "sentiment";
    protected static final String REMARK_ATTRIBUTE = "remarks";
    protected static final String RETURN_ATTRIBUTE = "past-returns";
    protected static final String ENTRY_PRICE_ATTRIBUTE = "entry-price";
    protected static final String EXIT_PRICE_ATTRIBUTE = "exit-price";
    protected static final String EXPIRY_ATTRIBUTE = "expiry";
    protected static final String DONE_ATTRIBUTE = "done-status";
    protected static final String WORKSPACE = EditInstrumentCommand.COMMAND_WORD;

    public static final double UNDEFINED_PAST_RETURN_VALUE = -101;

    /**
     * Get a valid new name if name is being edited and stores it.
     * @param instrumentType Type of instrument being edited
     * @param parametersGiven All the parameters to be edited
     * @throws OperationAbortedError When abort is being input to cancel operation
     */
    public void editNameParameter(String instrumentType, HashSet<String> parametersGiven)
            throws OperationAbortedError {
        if (!parametersGiven.contains(NAME_ATTRIBUTE)) {
            return;
        }
        String inputName;
        do {
            TextUi.displayEditName();
            inputName = getUserInput(WORKSPACE);
            checkIfAbort(inputName, WORKSPACE);
        } while (!Validate.isValidName(inputName, instrumentType));
        editedParameters.put(NAME_ATTRIBUTE, inputName);
    }

    /**
     * Get a valid new current price if current price is being edited and stores it.
     * @param parametersGiven All the parameters to be edited
     * @throws OperationAbortedError When abort is being input to cancel operation
     */
    public void editCurrentPriceParameter(HashSet<String> parametersGiven)
            throws OperationAbortedError {
        if (!parametersGiven.contains(CURRENT_PRICE_ATTRIBUTE)) {
            return;
        }
        String inputCurrentPrice;
        do {
            TextUi.displayEditCurrentPrice();
            inputCurrentPrice = getUserInput(WORKSPACE);
            checkIfAbort(inputCurrentPrice, WORKSPACE);
        } while (!Validate.isValidPrice(inputCurrentPrice));
        editedParameters.put(CURRENT_PRICE_ATTRIBUTE, inputCurrentPrice);
    }

    /**
     * Get a valid new sentiment if sentiment is being edited and stores it.
     * @param parametersGiven All the parameters to be edited
     * @throws OperationAbortedError When abort is being input to cancel operation
     */
    public void editSentimentsParameter(HashSet<String> parametersGiven)
            throws OperationAbortedError {
        if (!parametersGiven.contains(SENTIMENT_ATTRIBUTE)) {
            return;
        }
        String inputSentiment;
        do {
            TextUi.displayEditSentiment();
            inputSentiment = getUserInput(WORKSPACE).toLowerCase();
            checkIfAbort(inputSentiment, WORKSPACE);
        } while (!Validate.isValidSentiment(inputSentiment));
        editedParameters.put(SENTIMENT_ATTRIBUTE, inputSentiment);
    }

    /**
     * Get new remarks if remarks is being edited and stores it.
     * @param parametersGiven All the parameters to be edited
     * @throws OperationAbortedError When abort is being input to cancel operation
     */
    public void editRemarksParameter(HashSet<String> parametersGiven)
            throws OperationAbortedError {
        if (!parametersGiven.contains(REMARK_ATTRIBUTE)) {
            return;
        }
        TextUi.displayEditRemark();
        String inputRemark = getUserInput(WORKSPACE);
        checkIfAbort(inputRemark, WORKSPACE);
        editedParameters.put(REMARK_ATTRIBUTE, inputRemark);
    }

    /**
     * Get a new past return if past return is being edited and stores it.
     * @param parametersGiven All the parameters to be edited
     * @throws OperationAbortedError When abort is being input to cancel operation
     */
    public void editReturnParameter(HashSet<String> parametersGiven)
            throws OperationAbortedError {
        if (!parametersGiven.contains(RETURN_ATTRIBUTE)) {
            return;
        }
        TextUi.displayEditReturn();
        String inputReturn = getUserInput(WORKSPACE);
        checkIfAbort(inputReturn, WORKSPACE);
        if (!Validate.isValidPastReturns(inputReturn)) {
            inputReturn = String.valueOf(UNDEFINED_PAST_RETURN_VALUE);
        }
        editedParameters.put(RETURN_ATTRIBUTE, inputReturn);
    }

    /**
     * Get a new entry price if entry price is being edited and stores it.
     * @param parametersGiven All the parameters to be edited
     * @throws OperationAbortedError When abort is being input to cancel operation
     */
    public void editEntryPriceParameter(HashSet<String> parametersGiven)
            throws OperationAbortedError {
        if (!parametersGiven.contains(ENTRY_PRICE_ATTRIBUTE)) {
            return;
        }
        String inputEntryPrice;
        do {
            TextUi.displayEditEntryPrice();
            inputEntryPrice = getUserInput(WORKSPACE);
            checkIfAbort(inputEntryPrice, WORKSPACE);
        } while (!Validate.isValidPrice(inputEntryPrice));
        editedParameters.put(ENTRY_PRICE_ATTRIBUTE, inputEntryPrice);
    }

    /**
     * Get a new exit price if exit price is being edited and stores it.
     * @param parametersGiven All the parameters to be edited
     * @throws OperationAbortedError When abort is being input to cancel operation
     */
    public void editExitPriceParameter(HashSet<String> parametersGiven)
            throws OperationAbortedError {
        if (!parametersGiven.contains(EXIT_PRICE_ATTRIBUTE)) {
            return;
        }
        String inputExitPrice;
        do {
            TextUi.displayEditExitPrice();
            inputExitPrice = getUserInput(WORKSPACE);
            checkIfAbort(inputExitPrice, WORKSPACE);
        } while (!Validate.isValidPrice(inputExitPrice));
        editedParameters.put(EXIT_PRICE_ATTRIBUTE, inputExitPrice);
    }

    /**
     * Get the new done status if done status is being edited and stores it.
     * @param parametersGiven All the parameters to be edited
     * @throws OperationAbortedError When abort is being input to cancel operation
     */
    public void editDoneStatus(HashSet<String> parametersGiven) throws OperationAbortedError {
        if (!parametersGiven.contains(DONE_ATTRIBUTE)) {
            return;
        }
        String inputStatus;
        do {
            TextUi.displayEditStatus();
            inputStatus = getUserInput(WORKSPACE).toLowerCase();
            checkIfAbort(inputStatus, WORKSPACE);
        } while (!Validate.isValidInputStatus(inputStatus));
        editedParameters.put(DONE_ATTRIBUTE, inputStatus);
    }

    /**
     * Get a new Expiry if expiry is being edited and stores it.
     * @param parametersGiven All the parameters to be edited
     * @throws OperationAbortedError When abort is being input to cancel operation
     */
    public void editExpiryParameter(HashSet<String> parametersGiven)
            throws OperationAbortedError {
        if (!parametersGiven.contains(EXPIRY_ATTRIBUTE)) {
            return;
        }
        String inputExpiry;
        do {
            TextUi.displayEditExpiry();
            inputExpiry = getUserInput(WORKSPACE);
            checkIfAbort(inputExpiry, WORKSPACE);
        } while (!Validate.isValidExpiry(inputExpiry));
        editedParameters.put(EXPIRY_ATTRIBUTE, inputExpiry);
    }

    /**
     * Get all the new parameters being edited.
     * @param parametersGiven All the parameters to be edited
     * @param instrumentOfInterest The instrument being edited
     * @throws OperationAbortedError When abort is being input to cancel operation
     */
    public void getEditedParameters(HashSet<String> parametersGiven, Instrument instrumentOfInterest)
            throws OperationAbortedError {
        String instrumentType = instrumentOfInterest.getType().toLowerCase();
        editNameParameter(instrumentType, parametersGiven);
        editCurrentPriceParameter(parametersGiven);
        editSentimentsParameter(parametersGiven);
        editReturnParameter(parametersGiven);
        editEntryPriceParameter(parametersGiven);
        editExitPriceParameter(parametersGiven);
        editExpiryParameter(parametersGiven);
        editRemarksParameter(parametersGiven);
        editDoneStatus(parametersGiven);
    }

    /**
     * Get all the new values for all parameters being edited and
     * send the new values to the command.
     * @param parametersGiven All the parameters to be edited
     * @param instrumentOfInterest The instrument being edited
     * @param instrumentIndex Index of instrument being edited
     * @return EditInstrumentCommand with index and parameters being edited with their updated values
     * @throws OperationAbortedError When abort is being input to cancel operation
     */
    public EditInstrumentCommand createEditCommand(HashSet<String> parametersGiven,
                                                     Instrument instrumentOfInterest, int instrumentIndex)
            throws OperationAbortedError {
        EditInstrumentCommand command;
        editedParameters = new HashMap<>();
        getEditedParameters(parametersGiven, instrumentOfInterest);
        command = new EditInstrumentCommand(editedParameters);
        command.setIndex(instrumentIndex);
        return command;
    }

    /**
     * Get the list containing all the new values of parameters being edited.
     * @return list containing all the new values of parameters being edited
     */
    public static HashMap<String, String> getEditedParametersHash() {
        return editedParameters;
    }
}
