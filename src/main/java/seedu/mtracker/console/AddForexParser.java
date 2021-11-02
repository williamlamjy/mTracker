package seedu.mtracker.console;

import seedu.mtracker.commands.AddForexCommand;
import seedu.mtracker.commons.Validate;
import seedu.mtracker.ui.TextUi;
import seedu.mtracker.asserthelpers.AssertParserHelper;

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

    public void addForexEntryToParameter() {
        String entryPrice;
        do {
            entryPrice = getForexEntryFromUser();
        } while (!Validate.isValidPrice(entryPrice));
        parameters.add(entryPrice);
        AssertParserHelper.assertInputNotEmpty(entryPrice);
        AssertParserHelper.assertPriceNonNegative(entryPrice);
    }

    public void addForexExitToParameter() {
        String exitPrice;
        do {
            exitPrice = getForexExitFromUser();
        } while (!Validate.isValidPrice(exitPrice));
        parameters.add(exitPrice);
        AssertParserHelper.assertInputNotEmpty(exitPrice);
        AssertParserHelper.assertPriceNonNegative(exitPrice);
    }

    public void addForexExpiryToParameter() {
        String expiry;
        do {
            expiry = getForexExpiryFromUser();
        } while (!Validate.isValidExpiry(expiry));
        parameters.add(expiry);
        AssertParserHelper.assertExpiryInTheFuture(expiry);
        AssertParserHelper.assertInputNotEmpty(expiry);
    }

    public void getForexSpecificParameters() {
        addForexEntryToParameter();
        addForexExitToParameter();
        addForexExpiryToParameter();
        addForexRemarksToParameter();
    }

    @Override
    public AddForexCommand getInstrumentParameters() {
        getGeneralParameters(INSTRUMENT_TYPE);
        getForexSpecificParameters();
        AssertParserHelper.assertNoMissingForexParameters(parameters);
        return new AddForexCommand();
    }
}
