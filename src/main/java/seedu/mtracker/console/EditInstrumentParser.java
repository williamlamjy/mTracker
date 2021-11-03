package seedu.mtracker.console;

import seedu.mtracker.commands.EditInstrumentCommand;
import seedu.mtracker.commons.Validate;
import seedu.mtracker.error.ErrorMessage;
import seedu.mtracker.error.OperationAbortedError;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.util.HashMap;
import java.util.HashSet;

public class EditInstrumentParser extends InputParser {

    protected static HashMap<String, String> editedParameters;

    protected static final String NAME_ATTRIBUTE = "name";
    protected static final String CURRENT_PRICE_ATTRIBUTE = "current-price";
    protected static final String SENTIMENT_ATTRIBUTE = "sentiment";
    protected static final String REMARK_ATTRIBUTE = "remark";
    protected static final String RETURN_ATTRIBUTE = "returns";
    protected static final String ENTRY_PRICE_ATTRIBUTE = "entry-price";
    protected static final String EXIT_PRICE_ATTRIBUTE = "exit-price";
    protected static final String EXPIRY_ATTRIBUTE = "expiry";
    protected static final String WORKSPACE = EditInstrumentCommand.COMMAND_WORD;

    public static void editNameParameter(String instrumentType, HashSet<String> parametersGiven)
            throws OperationAbortedError {
        if (!parametersGiven.contains(NAME_ATTRIBUTE)) {
            return;
        }
        TextUi.displayEditName();
        String inputName;
        do {
            inputName = getUserInput(WORKSPACE);
            checkIfAbort(inputName, WORKSPACE);
        } while (!Validate.isValidName(inputName, instrumentType));
        editedParameters.put(NAME_ATTRIBUTE, inputName);
    }

    public static void editCurrentPriceParameter(HashSet<String> parametersGiven)
            throws OperationAbortedError {
        if (!parametersGiven.contains(CURRENT_PRICE_ATTRIBUTE)) {
            return;
        }
        TextUi.displayEditCurrentPrice();
        String inputCurrentPrice;
        do {
            inputCurrentPrice = getUserInput(WORKSPACE);
            checkIfAbort(inputCurrentPrice, WORKSPACE);
        } while (!Validate.isValidPrice(inputCurrentPrice));
        editedParameters.put(CURRENT_PRICE_ATTRIBUTE, inputCurrentPrice);
    }

    public static void editSentimentsParameter(HashSet<String> parametersGiven)
            throws OperationAbortedError {
        if (!parametersGiven.contains(SENTIMENT_ATTRIBUTE)) {
            return;
        }
        TextUi.displayEditSentiment();
        String inputSentiment;
        do {
            inputSentiment = getUserInput(WORKSPACE);
            checkIfAbort(inputSentiment, WORKSPACE);
        } while (!Validate.isValidSentiment(inputSentiment));
        editedParameters.put(SENTIMENT_ATTRIBUTE, inputSentiment);
    }

    public static void editRemarksParameter(HashSet<String> parametersGiven)
            throws OperationAbortedError {
        if (!parametersGiven.contains(REMARK_ATTRIBUTE)) {
            return;
        }
        TextUi.displayEditRemark();
        String inputRemark = getUserInput(WORKSPACE);
        checkIfAbort(inputRemark, WORKSPACE);
        editedParameters.put(REMARK_ATTRIBUTE, inputRemark);
    }

    public static void editReturnParameter(HashSet<String> parametersGiven)
            throws OperationAbortedError {
        if (!parametersGiven.contains(RETURN_ATTRIBUTE)) {
            return;
        }
        TextUi.displayEditReturn();
        String inputReturn;
        do {
            inputReturn = getUserInput(WORKSPACE);
            checkIfAbort(inputReturn, WORKSPACE);
        } while (!Validate.isValidPastReturn(inputReturn));
        editedParameters.put(RETURN_ATTRIBUTE, inputReturn);
    }

    public static void editEntryPriceParameter(HashSet<String> parametersGiven)
            throws OperationAbortedError {
        if (!parametersGiven.contains(ENTRY_PRICE_ATTRIBUTE)) {
            return;
        }
        TextUi.displayEditEntryPrice();
        String inputEntryPrice;
        do {
            inputEntryPrice = getUserInput(WORKSPACE);
            checkIfAbort(inputEntryPrice, WORKSPACE);
        } while (!Validate.isValidPrice(inputEntryPrice));
        editedParameters.put(ENTRY_PRICE_ATTRIBUTE, inputEntryPrice);
    }

    public static void editExitPriceParameter(HashSet<String> parametersGiven)
            throws OperationAbortedError {
        if (!parametersGiven.contains(EXIT_PRICE_ATTRIBUTE)) {
            return;
        }
        TextUi.displayEditExitPrice();
        String inputExitPrice;
        do {
            inputExitPrice = getUserInput(WORKSPACE);
            checkIfAbort(inputExitPrice, WORKSPACE);
        } while (!Validate.isValidPrice(inputExitPrice));
        editedParameters.put(EXIT_PRICE_ATTRIBUTE, inputExitPrice);
    }

    public static void editExpiryParameter(HashSet<String> parametersGiven)
            throws OperationAbortedError {
        if (!parametersGiven.contains(EXPIRY_ATTRIBUTE)) {
            return;
        }
        TextUi.displayEditExpiry();
        String inputExpiry;
        do {
            inputExpiry = getUserInput(WORKSPACE);
            checkIfAbort(inputExpiry, WORKSPACE);
        } while (!Validate.isValidExpiry(inputExpiry));
        editedParameters.put(EXPIRY_ATTRIBUTE, inputExpiry);
    }

    public static void getEditedParameters(HashSet<String> parametersGiven, Instrument instrumentOfInterest)
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
    }

    public EditInstrumentCommand getParametersToEdit(HashSet<String> parametersGiven,
                                                     Instrument instrumentOfInterest, int instrumentIndex)
            throws OperationAbortedError {
        EditInstrumentCommand command;
        editedParameters = new HashMap<>();
        EditInstrumentParser.getEditedParameters(parametersGiven, instrumentOfInterest);
        command = new EditInstrumentCommand(editedParameters);
        command.setIndex(instrumentIndex);
        return command;
    }
}
