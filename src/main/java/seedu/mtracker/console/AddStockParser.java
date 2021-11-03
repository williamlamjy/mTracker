package seedu.mtracker.console;

import seedu.mtracker.asserthelpers.AssertParserHelper;
import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.commands.AddStockCommand;
import seedu.mtracker.error.OperationAbortedError;
import seedu.mtracker.ui.TextUi;

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
    public AddInstrumentCommand getInstrumentParameters() throws OperationAbortedError {
        getGeneralParameters(STOCK_TYPE);
        getStockSpecificParameters();
        AssertParserHelper.assertNoMissingStockParameters(parameters);
        return new AddStockCommand();
    }
}
