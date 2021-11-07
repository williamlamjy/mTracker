package seedu.mtracker.commands;

import seedu.mtracker.model.subinstrument.Etf;
import seedu.mtracker.ui.TextUi;

//@@author kum-wh
/**
 * Responsible for adding Etf to the list.
 */
public class AddEtfCommand extends AddInstrumentCommand {

    public static final String COMMAND_WORD = "etf";

    public static final int PAST_RETURN_INDEX = 3;
    public static final int REMARK_INDEX = 4;

    protected double pastReturnParameter;
    protected String remarkParameter;

    public void setEtfParameters() {
        remarkParameter = inputParameters.get(REMARK_INDEX);
        pastReturnParameter = Double.parseDouble(inputParameters.get(PAST_RETURN_INDEX));
    }

    public void createNewEtf() {
        newInstrument = new Etf(nameParameter, currentPriceParameter,
                sentimentParameter, pastReturnParameter, remarkParameter);
    }

    /**
     * Handles the execution of adding Etf to the list.
     *
     * @return The name of the command.
     */
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
