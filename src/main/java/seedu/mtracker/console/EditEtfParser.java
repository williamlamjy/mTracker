package seedu.mtracker.console;

import seedu.mtracker.model.Instrument;
import seedu.mtracker.ui.TextUi;

import java.util.HashSet;

public class EditEtfParser extends EditInstrumentParser {

    public void editReturnParameter(HashSet<String> parametersGiven) {
        if (!parametersGiven.contains(RETURN_ATTRIBUTE)) {
            return;
        }
        TextUi.displayAddPastReturnsInstruction();
        String inputRemark = getUserInput();
        editedParameters.put(RETURN_ATTRIBUTE, inputRemark);
    }

    @Override
    public void getEditedParameters(HashSet<String> parametersGiven, Instrument instrumentOfInterest) {
        super.getEditedParameters(parametersGiven,instrumentOfInterest);
        editReturnParameter(parametersGiven);
    }
}
