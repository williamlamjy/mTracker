package seedu.mtracker.console;

import seedu.mtracker.commands.AddForexCommand;
import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.commons.Validate;
import seedu.mtracker.error.OperationAbortedError;
import seedu.mtracker.ui.TextUi;
import seedu.mtracker.asserthelpers.AssertParserHelper;

import javax.management.openmbean.OpenDataException;

import static seedu.mtracker.commons.Validate.checkIfAbort;

public class AddForexParser extends AddInstrumentParser {
    public static String INSTRUMENT_TYPE = "forex";

    public String getForexRemarksFromUser() {
        TextUi.displayAddRemarksInstruction();
        return getUserInput(WORKSPACE);
    }

    public String getForexExpiryFromUser() {
        TextUi.displayAddExpiryInstruction();
        return getUserInput(WORKSPACE);
    }

    public String getForexEntryFromUser() {
        TextUi.displayAddEntryPriceInstruction();
        return getUserInput(WORKSPACE);
    }

    public String getForexExitFromUser() {
        TextUi.displayAddExitPriceInstruction();
        return getUserInput(WORKSPACE);
    }

    public void addForexRemarksToParameter() {
        String remarks = getForexRemarksFromUser();
        parameters.add(remarks);
    }

    public void addForexEntryToParameter() throws OperationAbortedError {
        String entryPrice;
        do {
            entryPrice = getForexEntryFromUser();
            checkIfAbort(entryPrice, WORKSPACE);
        } while (!Validate.isValidPrice(entryPrice));
        parameters.add(entryPrice);
        AssertParserHelper.assertInputNotEmpty(entryPrice);
        AssertParserHelper.assertPriceNonNegative(entryPrice);
    }

    public void addForexExitToParameter() throws OperationAbortedError {
        String exitPrice;
        do {
            exitPrice = getForexExitFromUser();
            checkIfAbort(exitPrice, WORKSPACE);
        } while (!Validate.isValidPrice(exitPrice));
        parameters.add(exitPrice);
        AssertParserHelper.assertInputNotEmpty(exitPrice);
        AssertParserHelper.assertPriceNonNegative(exitPrice);
    }

    public void addForexExpiryToParameter() throws OperationAbortedError {
        String expiry;
        do {
            expiry = getForexExpiryFromUser();
            checkIfAbort(expiry, WORKSPACE);
        } while (!Validate.isValidExpiry(expiry));
        parameters.add(expiry);
        AssertParserHelper.assertExpiryInTheFuture(expiry);
        AssertParserHelper.assertInputNotEmpty(expiry);
    }

    public void getForexSpecificParameters() throws OperationAbortedError {
        addForexEntryToParameter();
        addForexExitToParameter();
        addForexExpiryToParameter();
        addForexRemarksToParameter();
    }

    @Override
    public AddInstrumentCommand getInstrumentParameters() throws OperationAbortedError {
        getGeneralParameters(INSTRUMENT_TYPE);
        getForexSpecificParameters();
        AssertParserHelper.assertNoMissingForexParameters(parameters);
        return new AddForexCommand();
    }
}
