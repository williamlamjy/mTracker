package seedu.mtracker.commands;


import seedu.mtracker.ui.TextUi;

import java.util.HashMap;

public class EditStockCommand extends EditInstrumentCommand {

    public EditStockCommand(HashMap<String,String> editedParameters) {
        this.editedParameters = editedParameters;
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
        editRemark();
    }

}
