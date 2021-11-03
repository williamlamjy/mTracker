package seedu.mtracker.console;

import seedu.mtracker.asserthelpers.AssertParserHelper;
import seedu.mtracker.commands.AddStockCommand;
import seedu.mtracker.ui.TextUi;

public class AddStockParser extends AddInstrumentParser {

    public static String STOCK_TYPE = "stock";

    public String getStockRemarksFromUser() {
        TextUi.displayAddRemarksInstruction();
        return getUserInput(WORKSPACE);
    }

    public void addStockRemarksToParameters() {
        String remarks = getStockRemarksFromUser();
        parameters.add(remarks);
    }

    public void getStockSpecificParameters() {
        addStockRemarksToParameters();
    }

    @Override
    public AddStockCommand getInstrumentParameters() {
        getGeneralParameters(STOCK_TYPE);
        getStockSpecificParameters();
        AssertParserHelper.assertNoMissingStockParameters(parameters);
        return new AddStockCommand();
    }
}
