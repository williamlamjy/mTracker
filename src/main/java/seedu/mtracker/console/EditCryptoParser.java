package seedu.mtracker.console;

import seedu.mtracker.model.Instrument;

import java.util.HashSet;

public class EditCryptoParser extends EditInstrumentParser {

    @Override
    public void getEditedParameters(HashSet<String> parametersGiven, Instrument instrumentOfInterest) {
        super.getEditedParameters(parametersGiven,instrumentOfInterest);
    }
}
