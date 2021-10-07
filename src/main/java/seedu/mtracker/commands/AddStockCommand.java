package seedu.mtracker.commands;

import seedu.mtracker.instrument.subinstrument.Stock;

public class AddStockCommand extends AddInstrumentCommand {

    public static final String COMMAND_WORD = "stock";
    public static final int REMARK_INDEX = 3;

    protected String remarkParameter;

    public void setStockParameters() {
        remarkParameter = inputParameters.get(REMARK_INDEX);
    }

    @Override
    public String execute() {
        setAddGeneralParameters();
        setStockParameters();
        Stock newStock = new Stock(nameParameter, currentPriceParameter, sentimentParameter, remarkParameter);
        instrumentManager.addInstrument(newStock);
        return COMMAND_WORD;
    }
}
