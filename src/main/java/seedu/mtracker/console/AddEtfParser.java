package seedu.mtracker.console;

import seedu.mtracker.asserthelpers.AssertParserHelper;
import seedu.mtracker.commands.AddEtfCommand;
import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.commons.Validate;
import seedu.mtracker.ui.TextUi;

public class AddEtfParser extends AddInstrumentParser {

    public static String INSTRUMENT_TYPE = "etf";

    public String getEtfRemarkFromUser() {
        TextUi.displayAddRemarksInstruction();
        return getUserInput();
    }

    public String getEtfPastReturnFromUser() {
        TextUi.displayAddPastReturnsInstruction();
        return Validate.isValidPastReturn(getUserInput());
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
    public AddInstrumentCommand getInstrumentParameters() {
        getGeneralParameters(INSTRUMENT_TYPE);
        getEtfSpecificParameters();
        AssertParserHelper.assertNoMissingEtfParameters(parameters);
        return new AddEtfCommand();
    }
}
