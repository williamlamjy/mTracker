package seedu.mtracker.console;

import seedu.mtracker.commands.EditEtfCommand;
import seedu.mtracker.commands.EditInstrumentCommand;
import seedu.mtracker.commands.EditStockCommand;
import seedu.mtracker.commons.Validate;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.util.HashMap;
import java.util.HashSet;

public class EditInstrumentParser extends InputParser {

    protected static HashMap<String,String> editedParameters;

    protected static final String NAME_ATTRIBUTE = "name";
    protected static final String CURRENT_PRICE_ATTRIBUTE = "current-price";
    protected static final String SENTIMENT_ATTRIBUTE = "sentiment";
    protected static final String REMARK_ATTRIBUTE = "remark";
    protected static final String RETURN_ATTRIBUTE = "returns";
    protected static final String EDIT_ERROR_NAME = "Ignoring edit for name";
    protected static final String EDIT_ERROR_PRICE = "Ignoring edit for price";
    protected static final String EDIT_ERROR_SENTIMENT = "Ignoring edit for Sentiments";

    public void editNameParameter(String instrumentType, HashSet<String> parametersGiven) {
        if (!parametersGiven.contains(NAME_ATTRIBUTE)) {
            return;
        }
        TextUi.displayAddInstrumentNameInstruction(instrumentType);
        String inputName = getUserInput();
        if (!Validate.isValidName(inputName, instrumentType)) {
            System.out.println(EDIT_ERROR_NAME);
            return;
        }
        editedParameters.put(NAME_ATTRIBUTE,inputName);
    }

    public void editCurrentPriceParameter(HashSet<String> parametersGiven) {
        if (!parametersGiven.contains(CURRENT_PRICE_ATTRIBUTE)) {
            return;
        }
        TextUi.displayAddInstrumentCurrentPriceInstruction();
        String inputCurrentPrice = getUserInput();
        if (!Validate.isValidPrice(inputCurrentPrice)) {
            System.out.println(EDIT_ERROR_PRICE);
            return;
        }
        editedParameters.put(CURRENT_PRICE_ATTRIBUTE, inputCurrentPrice);
    }

    public void editSentimentsParameter(HashSet<String> parametersGiven) {
        if (!parametersGiven.contains(SENTIMENT_ATTRIBUTE)) {
            return;
        }
        TextUi.displayAddInstrumentSentimentInstruction();
        String inputSentiment = getUserInput();
        if (!Validate.isValidSentiment(inputSentiment)) {
            System.out.println(EDIT_ERROR_SENTIMENT);
            return;
        }
        editedParameters.put(SENTIMENT_ATTRIBUTE, inputSentiment);
    }

    public void editRemarksParameter(HashSet<String> parametersGiven) {
        if (!parametersGiven.contains(REMARK_ATTRIBUTE)) {
            return;
        }
        TextUi.displayAddRemarksInstruction();
        String inputRemark = getUserInput();
        editedParameters.put(REMARK_ATTRIBUTE, inputRemark);
    }


    public void getEditedParameters(HashSet<String> parametersGiven, Instrument instrumentOfInterest) {
        String instrumentType = instrumentOfInterest.getType();
        editNameParameter(instrumentType,parametersGiven);
        editCurrentPriceParameter(parametersGiven);
        editSentimentsParameter(parametersGiven);
        editRemarksParameter(parametersGiven);
    }

    public EditInstrumentCommand getParametersToEdit(HashSet<String> parametersGiven,
                                                     Instrument instrumentOfInterest, int instrumentIndex) {
        EditInstrumentCommand command;
        EditInstrumentParser editParser;
        editedParameters = new HashMap<>();
        String instrumentType = instrumentOfInterest.getType();
        switch (instrumentType) {
        case "Stock":
            editParser = new EditStockParser();
            editParser.getEditedParameters(parametersGiven,instrumentOfInterest);
            command = new EditStockCommand(editedParameters);
            break;
        case "Etf":
            editParser = new EditEtfParser();
            editParser.getEditedParameters(parametersGiven,instrumentOfInterest);
            command = new EditEtfCommand(editedParameters);
            break;
        case "Forex":
            editParser = new EditForexParser();
            editParser.getEditedParameters(parametersGiven,instrumentOfInterest);
            //command = new EditForexCommand(editedParameters);
            command = null;
            break;
        case "Crypto":
            editParser = new EditCryptoParser();
            editParser.getEditedParameters(parametersGiven,instrumentOfInterest);
            //command = new EditCryptoCommand(editedParameters);
            command = null;
            break;
        default:
            //this case shouldnt be reach
            command = null;
        }
        command.setIndex(instrumentIndex);
        return command;
    }
}