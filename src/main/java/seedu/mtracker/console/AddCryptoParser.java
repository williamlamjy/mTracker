package seedu.mtracker.console;

import seedu.mtracker.asserthelpers.AssertParserHelper;
import seedu.mtracker.commands.AddCryptoCommand;
import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.commons.Validate;
import seedu.mtracker.error.OperationAbortedError;
import seedu.mtracker.ui.TextUi;

import static seedu.mtracker.commons.Validate.checkIfAbort;

public class AddCryptoParser extends AddInstrumentParser {

    public static String INSTRUMENT_TYPE = "crypto";

    public String getCryptoRemarksFromUser() {
        TextUi.displayAddRemarksInstruction();
        return getUserInput(WORKSPACE);
    }

    public String getCryptoExpiryFromUser() {
        TextUi.displayAddExpiryInstruction();
        return getUserInput(WORKSPACE);
    }

    public void addCryptoExpiryToParameters() throws OperationAbortedError {
        String expiry;
        do {
            expiry = getCryptoExpiryFromUser();
            checkIfAbort(expiry, WORKSPACE);
        } while (!Validate.isValidExpiry(expiry));
        parameters.add(expiry);
        AssertParserHelper.assertExpiryInTheFuture(expiry);
    }

    public void addCryptoRemarksToParameters() throws OperationAbortedError {
        String remarks = getCryptoRemarksFromUser();
        checkIfAbort(remarks, WORKSPACE);
        parameters.add(remarks);
    }

    public void getCryptoSpecificParameters() throws OperationAbortedError {
        addCryptoExpiryToParameters();
        addCryptoRemarksToParameters();
    }

    @Override
    public AddInstrumentCommand getInstrumentParameters() throws OperationAbortedError {
        getGeneralParameters(INSTRUMENT_TYPE);
        getCryptoSpecificParameters();
        AssertParserHelper.assertNoMissingCryptoParameters(parameters);
        return new AddCryptoCommand();
    }
}
