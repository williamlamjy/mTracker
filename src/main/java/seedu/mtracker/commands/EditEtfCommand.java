package seedu.mtracker.commands;

import seedu.mtracker.ui.TextUi;

import java.util.HashMap;

public class EditEtfCommand extends EditInstrumentCommand {

    private static final int INDEX_OF_RETURN = 0;
    protected static final String RETURN_ATTRIBUTE = "returns";

    public EditEtfCommand(HashMap<String,String> editedParameters) {
        this.editedParameters = editedParameters;
    }

    protected void editReturn() {
        if (!editedParameters.containsKey(RETURN_ATTRIBUTE)) {
            return;
        }
        String previousReturn = instrumentToEdit.getSpecificParameter(INDEX_OF_RETURN);
        String inputReturn = editedParameters.get(RETURN_ATTRIBUTE);
        Double parseReturn = Double.parseDouble(inputReturn);
        instrumentToEdit.setSpecificParameter(parseReturn, INDEX_OF_RETURN);
        TextUi.displayEditReturn(previousReturn,inputReturn);
    }

    protected void editRemark() {
        if (!editedParameters.containsKey(REMARK_ATTRIBUTE)) {
            return;
        }
        String previousRemark = instrumentToEdit.getRemark();
        String inputRemark = editedParameters.get(REMARK_ATTRIBUTE);
        instrumentToEdit.setRemark(inputRemark);
        TextUi.displayEditRemark(previousRemark,inputRemark);
    }

    @Override
    protected void editGeneralParameters() {
        editName();
        editCurrentPrice();
        editSentiment();
        editReturn();
        editRemark();
    }
}
