package seedu.mtracker.console;

import seedu.mtracker.asserthelpers.AssertParserHelper;
import seedu.mtracker.commands.AddStockCommand;
import seedu.mtracker.commons.error.OperationAbortedError;
import seedu.mtracker.ui.TextUi;

//@@author theodorekwok
public class AddStockParser extends AddInstrumentParser {

    public static String STOCK_TYPE = "stock";

    public String getStockRemarksFromUser() {
        TextUi.displayAddRemarksInstruction();
        return getUserInput(WORKSPACE);
    }

    public void addStockRemarksToParameters() throws OperationAbortedError {
        String remarks = getStockRemarksFromUser();
        checkIfAbort(remarks, WORKSPACE);
        parameters.add(remarks);
    }

    public void getStockSpecificParameters() throws OperationAbortedError {
        addStockRemarksToParameters();
    }

    @Override
    public AddStockCommand getInstrumentParameters() throws OperationAbortedError {
        getGeneralParameters(STOCK_TYPE);
        getStockSpecificParameters();
        AssertParserHelper.assertNoMissingStockParameters(parameters);
        return new AddStockCommand();
    }
}
