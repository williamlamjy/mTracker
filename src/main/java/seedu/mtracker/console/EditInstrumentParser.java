package seedu.mtracker.console;

import seedu.mtracker.commands.EditInstrumentCommand;
import seedu.mtracker.commons.Validate;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.util.HashMap;
import java.util.HashSet;

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

    public static void editNameParameter(String instrumentType, HashSet<String> parametersGiven) {
        if (!parametersGiven.contains(NAME_ATTRIBUTE)) {
            return;
        }
        String inputName;
        do {
            TextUi.displayEditName();
            inputName = getUserInput(WORKSPACE);
        } while (!Validate.isValidName(inputName, instrumentType));
        editedParameters.put(NAME_ATTRIBUTE, inputName);
    }

    public static void editCurrentPriceParameter(HashSet<String> parametersGiven) {
        if (!parametersGiven.contains(CURRENT_PRICE_ATTRIBUTE)) {
            return;
        }
        String inputCurrentPrice;
        do {
            TextUi.displayEditCurrentPrice();
            inputCurrentPrice = getUserInput(WORKSPACE);
        } while (!Validate.isValidPrice(inputCurrentPrice));
        editedParameters.put(CURRENT_PRICE_ATTRIBUTE, inputCurrentPrice);
    }

    public static void editSentimentsParameter(HashSet<String> parametersGiven) {
        if (!parametersGiven.contains(SENTIMENT_ATTRIBUTE)) {
            return;
        }
        String inputSentiment;
        do {
        TextUi.displayEditSentiment();
        inputSentiment = getUserInput(WORKSPACE);
        } while (!Validate.isValidSentiment(inputSentiment));
        editedParameters.put(SENTIMENT_ATTRIBUTE, inputSentiment);
    }

    public static void editRemarksParameter(HashSet<String> parametersGiven) {
        if (!parametersGiven.contains(REMARK_ATTRIBUTE)) {
            return;
        }
        TextUi.displayEditRemark();
        String inputRemark = getUserInput(WORKSPACE);
        editedParameters.put(REMARK_ATTRIBUTE, inputRemark);
    }

    public static void editReturnParameter(HashSet<String> parametersGiven) {
        if (!parametersGiven.contains(RETURN_ATTRIBUTE)) {
            return;
        }
        String inputReturn;
        do {
            TextUi.displayEditReturn();
            inputReturn = getUserInput(WORKSPACE);
        } while (!Validate.isValidPastReturn(inputReturn));
        editedParameters.put(RETURN_ATTRIBUTE, inputReturn);
    }

    public static void editEntryPriceParameter(HashSet<String> parametersGiven) {
        if (!parametersGiven.contains(ENTRY_PRICE_ATTRIBUTE)) {
            return;
        }
        String inputEntryPrice;
        do {
            TextUi.displayEditEntryPrice();
            inputEntryPrice = getUserInput(WORKSPACE);
        } while (!Validate.isValidPrice(inputEntryPrice));
        editedParameters.put(ENTRY_PRICE_ATTRIBUTE, inputEntryPrice);
    }

    public static void editExitPriceParameter(HashSet<String> parametersGiven) {
        if (!parametersGiven.contains(EXIT_PRICE_ATTRIBUTE)) {
            return;
        }
        String inputExitPrice;
        do {
            TextUi.displayEditExitPrice();
            inputExitPrice = getUserInput(WORKSPACE);
        } while (!Validate.isValidPrice(inputExitPrice));
        editedParameters.put(EXIT_PRICE_ATTRIBUTE, inputExitPrice);
    }

    public static void editExpiryParameter(HashSet<String> parametersGiven) {
        if (!parametersGiven.contains(EXPIRY_ATTRIBUTE)) {
            return;
        }
        String inputExpiry;
        do {
            TextUi.displayEditExpiry();
            inputExpiry = getUserInput(WORKSPACE);
        } while (!Validate.isValidExpiry(inputExpiry));
        editedParameters.put(EXPIRY_ATTRIBUTE, inputExpiry);
    }

    public static void editDoneStatus(HashSet<String> parametersGiven) {
        if (!parametersGiven.contains(DONE_ATTRIBUTE)) {
            return;
        }
        String inputStatus;
        do {
            TextUi.displayEditStatus();
            inputStatus = getUserInput(WORKSPACE);
        } while (!Validate.isValidStatus(inputStatus));
        editedParameters.put(DONE_ATTRIBUTE, inputStatus);
    }

    public static void getEditedParameters(HashSet<String> parametersGiven, Instrument instrumentOfInterest) {
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

    public EditInstrumentCommand createEditCommand(HashSet<String> parametersGiven,
                                                   Instrument instrumentOfInterest, int instrumentIndex) {
        EditInstrumentCommand command;
        editedParameters = new HashMap<>();
        EditInstrumentParser.getEditedParameters(parametersGiven, instrumentOfInterest);
        command = new EditInstrumentCommand(editedParameters);
        command.setIndex(instrumentIndex);
        return command;
    }

    public static HashMap<String, String> getEditedParametersHash() {
        return editedParameters;
    }
}
