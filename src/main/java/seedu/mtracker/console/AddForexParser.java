package seedu.mtracker.console;

import seedu.mtracker.commands.AddForexCommand;
import seedu.mtracker.commons.Validate;
import seedu.mtracker.commons.error.OperationAbortedError;
import seedu.mtracker.ui.TextUi;
import seedu.mtracker.asserthelpers.AssertParserHelper;

/**
 * A class responsible for parsing inputs when user is adding a new forex instrument.
 */
public class AddForexParser extends AddInstrumentParser {
    public static String INSTRUMENT_TYPE = "forex";

    /**
     * Queries and gets forex remarks from the user.
     *
     * @return User remarks input.
     */
    public String getForexRemarksFromUser() {
        TextUi.displayAddRemarksInstruction();
        return getUserInput(WORKSPACE);
    }

    /**
     * Queries and gets forex expiry date from the user.
     *
     * @return User expiry date input.
     */
    public String getForexExpiryFromUser() {
        TextUi.displayAddExpiryInstruction();
        return getUserInput(WORKSPACE);
    }

    /**
     * Queries and gets forex entry price from the user.
     *
     * @return User entry price input.
     */
    public String getForexEntryFromUser() {
        TextUi.displayAddEntryPriceInstruction();
        return getUserInput(WORKSPACE);
    }

    /**
     * Queries and gets forex exit price from the user.
     *
     * @return User exit price input.
     */
    public String getForexExitFromUser() {
        TextUi.displayAddExitPriceInstruction();
        return getUserInput(WORKSPACE);
    }

    /**
     * Gets the user forex remarks input and adds it into the parameters list.
     *
     * @throws OperationAbortedError If the user wants to abort the add forex process.
     */
    public void addForexRemarksToParameter() throws OperationAbortedError {
        String remarks = getForexRemarksFromUser();
        checkIfAbort(remarks, WORKSPACE);
        parameters.add(remarks);
    }

    /**
     * Gets the user forex entry price input and adds it into the parameters list.
     *
     * @throws OperationAbortedError If the user wants to abort the add forex process.
     */
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

    /**
     * Gets the user forex exit price input and adds it into the parameters list.
     *
     * @throws OperationAbortedError If the user wants to abort the add forex process.
     */
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

    /**
     * Gets the user forex expiry date input and adds it into the parameters.
     *
     * @throws OperationAbortedError If the user wants to abort the add forex process.
     */
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

    /**
     * Gets forex specific parameters from the user parameters when adding a new forex instrument.
     *
     * @throws OperationAbortedError If the user wants to abort the add forex process.
     */
    public void getForexSpecificParameters() throws OperationAbortedError {
        addForexEntryToParameter();
        addForexExitToParameter();
        addForexExpiryToParameter();
        addForexRemarksToParameter();
    }

    /**
     * Gets from the user all parameters needed to create a new forex instrument.
     *
     * @return A command for adding a new forex.
     * @throws OperationAbortedError If the user wants to abort the add forex process.
     */
    @Override
    public AddForexCommand getInstrumentParameters() throws OperationAbortedError {
        getGeneralParameters(INSTRUMENT_TYPE);
        getForexSpecificParameters();
        AssertParserHelper.assertNoMissingForexParameters(parameters);
        return new AddForexCommand();
    }
}
