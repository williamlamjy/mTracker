package seedu.mtracker.console;

import seedu.mtracker.asserthelpers.AssertParserHelper;
import seedu.mtracker.commands.AddEtfCommand;
import seedu.mtracker.commons.Validate;
import seedu.mtracker.ui.TextUi;

public class AddEtfParser extends AddInstrumentParser {

    public static String INSTRUMENT_TYPE = "etf";
    public static final double UNDEFINED_PAST_RETURN_VALUE = -101;

    public String getEtfRemarkFromUser() {
        TextUi.displayAddRemarksInstruction();
        return getUserInput(WORKSPACE);
    }

    public String getEtfPastReturnFromUser() {
        TextUi.displayAddPastReturnsInstruction();
        String userInput = getUserInput(WORKSPACE);
        if (!Validate.isValidPastReturns(userInput)) {
            return String.valueOf(UNDEFINED_PAST_RETURN_VALUE);
        }
        return userInput;
    }

    public void addEtfRemarkToParameters() {
        String remarks = getEtfRemarkFromUser();
        parameters.add(remarks);
    }

    public void addEtfPastReturnToParameters() {
        String pastReturns = getEtfPastReturnFromUser();
        parameters.add(pastReturns);
    }

    public void getEtfSpecificParameters() {
        addEtfPastReturnToParameters();
        addEtfRemarkToParameters();
    }

    @Override
    public AddEtfCommand getInstrumentParameters() {
        getGeneralParameters(INSTRUMENT_TYPE);
        getEtfSpecificParameters();
        AssertParserHelper.assertNoMissingEtfParameters(parameters);
        return new AddEtfCommand();
    }
}
