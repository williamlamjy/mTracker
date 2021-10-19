package seedu.mtracker.console;

import seedu.mtracker.commands.AddForexCommand;
import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.ui.TextUi;
import seedu.mtracker.asserthelpers.AssertParserHelper;

public class AddForexParser extends AddInstrumentParser {
    public static String INSTRUMENT_TYPE = "forex";

    public String getForexRemarksFromUser() {
        TextUi.displayAddRemarksInstruction();
        return getUserInput();
    }

    public String getForexExpiryFromUser() {
        TextUi.displayAddExpiryInstruction();
        return getUserInput();
    }

    public String getForexEntryFromUser() {
        TextUi.displayAddEntryPriceInstruction();
        return getUserInput();
    }

    public String getForexExitFromUser() {
        TextUi.displayAddExitPriceInstruction();
        return getUserInput();
    }

    public void addForexRemarksToParameter() {
        String remarks = getForexRemarksFromUser();
        parameters.add(remarks);
    }

    public void addForexEntryToParameter() {
        String entryPrice;
        do {
            entryPrice = getForexEntryFromUser();
        } while (!isValidPrice(entryPrice));
        parameters.add(entryPrice);
        AssertParserHelper.assertInputNotEmpty(entryPrice);
        AssertParserHelper.assertPriceNonNegative(entryPrice);
    }

    public void addForexExitToParameter() {
        String exitPrice;
        do {
            exitPrice = getForexExitFromUser();
        } while (!isValidPrice(exitPrice));
        parameters.add(exitPrice);
        AssertParserHelper.assertInputNotEmpty(exitPrice);
        AssertParserHelper.assertPriceNonNegative(exitPrice);
    }

    public void addForexExpiryToParameter() {
        String expiry;
        do {
            expiry = getForexExpiryFromUser();
        } while (!isValidExpiry(expiry));
        parameters.add(expiry);
        AssertParserHelper.assertInputNotEmpty(expiry);
    }

    public void getForexSpecificParameters() {
        addForexEntryToParameter();
        addForexExitToParameter();
        addForexExpiryToParameter();
        addForexRemarksToParameter();
    }

    @Override
    public AddInstrumentCommand getInstrumentParameters() {
        getGeneralParameters(INSTRUMENT_TYPE);
        getForexSpecificParameters();
        AssertParserHelper.assertNoMissingForexParameters(parameters);
        return new AddForexCommand();
    }
}
