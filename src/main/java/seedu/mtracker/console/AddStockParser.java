package seedu.mtracker.console;

import seedu.mtracker.asserthelpers.AssertParserHelper;
import seedu.mtracker.commands.AddStockCommand;
import seedu.mtracker.commons.error.OperationAbortedError;
import seedu.mtracker.ui.TextUi;

//@@author theodorekwok
/**
 * A class responsible for parsing inputs when user is adding a new stock instrument.
 */
public class AddStockParser extends AddInstrumentParser {

    public static String STOCK_TYPE = "stock";

    /**
     * Queries and gets stock remarks from the user.
     *
     * @return User remarks. input.
     */
    public String getStockRemarksFromUser() {
        TextUi.displayAddRemarksInstruction();
        return getUserInput(WORKSPACE);
    }

    /**
     * Gets the user stock remarks input and adds it into the parameters.
     *
     * @throws OperationAbortedError If the user wants to abort the add stock process.
     */
    public void addStockRemarksToParameters() throws OperationAbortedError {
        String remarks = getStockRemarksFromUser();
        checkIfAbort(remarks, WORKSPACE);
        parameters.add(remarks);
    }

    /**
     * Gets stock specific parameters from the user when adding a new stock instrument.
     *
     * @throws OperationAbortedError If the user wants to abort the add stock process.
     */
    public void getStockSpecificParameters() throws OperationAbortedError {
        addStockRemarksToParameters();
    }

    /**
     * Gets from the user all parameters needed to create a new stock instrument.
     *
     * @return A command for adding a new stock.
     * @throws OperationAbortedError If the user wants to abort the add stock process.
     */
    @Override
    public AddStockCommand getInstrumentParameters() throws OperationAbortedError {
        getGeneralParameters(STOCK_TYPE);
        getStockSpecificParameters();
        AssertParserHelper.assertNoMissingStockParameters(parameters);
        return new AddStockCommand();
    }
}
