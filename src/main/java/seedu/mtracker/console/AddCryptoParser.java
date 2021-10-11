package seedu.mtracker.console;

import seedu.mtracker.asserthelpers.AssertParserHelper;
import seedu.mtracker.commands.AddCryptoCommand;
import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.ui.TextUi;

public class AddCryptoParser extends AddInstrumentParser {

    public static String INSTRUMENT_TYPE = "crypto";

    public String getCryptoRemarksFromUser() {
        TextUi.displayAddRemarksInstruction();
        return getUserInput();
    }

    public String getCryptoExpiryFromUser() {
        TextUi.displayAddExpiryInstruction();
        return getUserInput();
    }

    public void addCryptoExpiryToParameters() {
        String expiry = getCryptoExpiryFromUser();
        parameters.add(expiry);
    }

    public void addCryptoRemarksToParameters() {
        String remarks = getCryptoRemarksFromUser();
        parameters.add(remarks);
    }

    public void getCryptoSpecificParameters() {
        addCryptoExpiryToParameters();
        addCryptoRemarksToParameters();
    }

    @Override
    public AddInstrumentCommand getInstrumentParameters() {
        getGeneralParameters(INSTRUMENT_TYPE);
        getCryptoSpecificParameters();
        AssertParserHelper.assertNoMissingCryptoParameters(parameters);
        return new AddCryptoCommand();
    }
}
