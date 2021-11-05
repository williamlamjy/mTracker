package seedu.mtracker.console;

import seedu.mtracker.commands.EditInstrumentCommand;
import seedu.mtracker.commons.Validate;
import seedu.mtracker.commons.error.OperationAbortedError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.util.HashMap;
import java.util.HashSet;

/**
 * A class responsible for parsing inputs when the user wants to edit an existing instrument.
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
     * Gets the user new name input and store it in a hashmap that maps the name attribute to input.
     * Process is skipped if the user does not want to edit the name.
     *
     * @param instrumentType The type of instrument user is editing.
     * @param parametersGiven The set of parameters of the instrument the user wants to edit.
     * @throws OperationAbortedError If the user wants to abort the edit instrument process.
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
     * Gets the user new current price input and store it in a hashmap that maps the current price attribute to input.
     * Process is skipped if the user does not want to edit the current price.
     *
     * @param parametersGiven The set of parameters of the instrument the user wants to edit.
     * @throws OperationAbortedError If the user wants to abort the edit instrument process.
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
     * Gets the user new sentiment input and store it in a hashmap that maps the sentiment attribute to input.
     * Process is skipped if the user does not want to edit the sentiment.
     *
     * @param parametersGiven The set of parameters of the instrument the user wants to edit.
     * @throws OperationAbortedError If the user wants to abort the edit instrument process.
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
     * Gets the user new remarks input and store it in a hashmap that maps the remarks attribute to input.
     * Process is skipped if the user does not want to edit the remarks.
     *
     * @param parametersGiven The set of parameters of the instrument the user wants to edit.
     * @throws OperationAbortedError If the user wants to abort the edit instrument process.
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
     * Gets the user new past returns input and store it in a hashmap that maps the past returns attribute to input.
     * Process is skipped if the user does not want to edit the past returns.
     *
     * @param parametersGiven The set of parameters of the instrument the user wants to edit.
     * @throws OperationAbortedError If the user wants to abort the edit instrument process.
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
     * Gets the user new entry price input and store it in a hashmap that maps the entry price attribute to input.
     * Process is skipped if the user does not want to edit the entry price.
     *
     * @param parametersGiven The set of parameters of the instrument the user wants to edit.
     * @throws OperationAbortedError If the user wants to abort the edit instrument process.
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
     * Gets the user new exit price input and store it in a hashmap that maps the exit price attribute to input.
     * Process is skipped if the user does not want to edit the exit price.
     *
     * @param parametersGiven The set of parameters of the instrument the user wants to edit.
     * @throws OperationAbortedError If the user wants to abort the edit instrument process.
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
     * Gets the user new done status input and store it in a hashmap that maps the status attribute to input.
     * Process is skipped if the user does not want to edit the status.
     *
     * @param parametersGiven The set of parameters of the instrument the user wants to edit.
     * @throws OperationAbortedError If the user wants to abort the edit instrument process.
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
     * Gets the user new expiry input and store it in a hashmap that maps the expiry attribute to input.
     * Process is skipped if the user does not want to edit the expiry.
     *
     * @param parametersGiven The set of parameters of the instrument the user wants to edit.
     * @throws OperationAbortedError If the user wants to abort the edit instrument process.
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
     * Gets from the user all the new values to needed to the update the existing instrument.
     *
     * @param parametersGiven The set of parameters of the instrument the user wants to edit.
     * @param instrumentOfInterest The instrument the user wants to edit.
     * @throws OperationAbortedError If the user wants to abort the edit instrument process.
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
     * Creates the edit command and gets from the user the new values to update the instrument with.
     *
     * @param parametersGiven The set of parameters of the instrument the user wants to edit.
     * @param instrumentOfInterest The instrument the user wants to edit.
     * @param instrumentIndex The index number of the instrument to edit.
     * @return A command for editing an existing instrument.
     * @throws OperationAbortedError If the user wants to abort the edit instrument process.
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
     * Gets the hashmap containing the instrument attributes and its edited value.
     *
     * @return A hashmap that contains the instrument attributes and its new value.
     */
    public static HashMap<String, String> getEditedParametersHash() {
        return editedParameters;
    }
}
