package seedu.mtracker.commands;

import seedu.mtracker.asserthelpers.AssertCommandHelpers;
import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.util.HashMap;

public class EditInstrumentCommand extends Command {

    public static final String COMMAND_WORD = "edit";
    public static final int UNINITIALISED_INDEX = -1;
    protected int index;
    protected Instrument instrumentToEdit;
    protected HashMap<String,String> editedParameters;

    protected static final String NAME_ATTRIBUTE = "name";
    protected static final String CURRENT_PRICE_ATTRIBUTE = "current-price";
    protected static final String SENTIMENT_ATTRIBUTE = "sentiment";
    protected static final String REMARK_ATTRIBUTE = "remark";

    public EditInstrumentCommand() {
        index = UNINITIALISED_INDEX;
        instrumentToEdit = null;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    protected void editName() {
        if (!editedParameters.containsKey(NAME_ATTRIBUTE)) {
            return;
        }
        String previousName = instrumentToEdit.getName();
        String inputName = editedParameters.get(NAME_ATTRIBUTE);
        instrumentToEdit.setName(inputName);
        TextUi.displayEditName(previousName,inputName);
    }

    protected void editCurrentPrice() {
        if (!editedParameters.containsKey(CURRENT_PRICE_ATTRIBUTE)) {
            return;
        }
        Double previousCurrentPrice = instrumentToEdit.getCurrentPrice();
        String parsepreviousPrice = previousCurrentPrice.toString();
        String inputCurrentPrice = editedParameters.get(CURRENT_PRICE_ATTRIBUTE);
        Double parseCurrentPrice = Double.parseDouble(inputCurrentPrice);
        instrumentToEdit.setCurrentPrice(parseCurrentPrice);
        TextUi.displayEditCurrentPrice(parsepreviousPrice,inputCurrentPrice);
    }

    protected void editSentiment() {
        if (!editedParameters.containsKey(SENTIMENT_ATTRIBUTE)) {
            return;
        }
        String previousSentiment = instrumentToEdit.getSentiment();
        String inputSentiment = editedParameters.get(SENTIMENT_ATTRIBUTE);
        instrumentToEdit.setSentiment(inputSentiment);
        TextUi.displayEditSentiment(previousSentiment,inputSentiment);
    }

    protected void editGeneralParameters() {
        editName();
        editCurrentPrice();
        editSentiment();
    }

    @Override
    public String execute() {
        AssertCommandHelpers.assertIndexWithinBounds(instrumentManager.getSize(), index);
        instrumentToEdit = instrumentManager.getInstrument(index);
        editGeneralParameters();
        return COMMAND_WORD;
    }
}
