package seedu.mtracker.console;

import seedu.mtracker.commands.AddStockCommand;
import seedu.mtracker.commands.Command;
import seedu.mtracker.ui.TextUi;

public class AddStockParser extends AddInstrumentParser {

    public static String STOCK_TYPE = "stock";

    public static String getStockRemarksFromUser() {
        TextUi.displayAddRemarksInstruction();
        return getUserInput();
    }

    public static void addStockRemarksToParameters() {
        String remarks = getStockRemarksFromUser();
        parameters.add(remarks);
    }

    public static void getStockSpecificParameters() {
        addStockRemarksToParameters();
    }

    public static Command getStockParameters() {
        getGeneralParameters(STOCK_TYPE);
        getStockSpecificParameters();

        return new AddStockCommand();
    }
}
