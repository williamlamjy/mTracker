package seedu.mtracker.commands;

import seedu.mtracker.instrument.subinstrument.Etf;
import seedu.mtracker.ui.TextUi;

public class AddEtfCommand extends AddInstrumentCommand {

    public static final String COMMAND_WORD = "etf";

    public static final int PAST_RETURNS_INDEX = 3;
    public static final int REMARK_INDEX = 4;

    private static final double UNDEFINED_PAST_RETURN_VALUE = 0;

    protected double pastReturnsParameter;
    protected String remarkParameter;

    public void setEtfParameters() {
        remarkParameter = inputParameters.get(REMARK_INDEX);
        try {
            pastReturnsParameter = Double.parseDouble(inputParameters.get(PAST_RETURNS_INDEX));
        } catch (NumberFormatException e) {
            pastReturnsParameter = UNDEFINED_PAST_RETURN_VALUE;
        }
    }

    public void createNewEtf() {
        newInstrument = new Etf(nameParameter, currentPriceParameter,
                sentimentParameter, pastReturnsParameter, remarkParameter);
    }

    @Override
    public String execute() {
        setAddGeneralParameters();
        setEtfParameters();
        createNewEtf();
        instrumentManager.addInstrument(newInstrument);
        TextUi.displayInstrumentAdded(newInstrument);
        return COMMAND_WORD;
    }
}
