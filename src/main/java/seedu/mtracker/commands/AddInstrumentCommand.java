package seedu.mtracker.commands;

import seedu.mtracker.instrument.Instrument;

public class AddInstrumentCommand extends Command {

    public static final String COMMAND_WORD = "add";
    public static final int NAME_INDEX = 0;
    public static final int CURRENT_PRICE_INDEX = 1;
    public static final int SENTIMENT_INDEX = 2;

    protected String nameParameter;
    protected Double currentPriceParameter;
    protected String sentimentParameter;
    protected Instrument newInstrument;

    public void setAddGeneralParameters() {
        nameParameter = inputParameters.get(NAME_INDEX);
        currentPriceParameter = Double.parseDouble(inputParameters.get(CURRENT_PRICE_INDEX));
        sentimentParameter = inputParameters.get(SENTIMENT_INDEX);
    }

    @Override
    public String execute() {
        return COMMAND_WORD;
    }
}
