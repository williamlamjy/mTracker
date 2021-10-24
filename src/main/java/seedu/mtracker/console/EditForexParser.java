package seedu.mtracker.console;

import seedu.mtracker.model.Instrument;

import java.util.HashSet;

public class EditForexParser extends EditInstrumentParser {

    @Override
    public void getEditedParameters(HashSet<String> parametersGiven, Instrument instrumentOfInterest) {
        super.getEditedParameters(parametersGiven,instrumentOfInterest);
    }
}
