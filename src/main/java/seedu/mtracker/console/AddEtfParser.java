package seedu.mtracker.console;

import seedu.mtracker.LogHelper;
import seedu.mtracker.asserthelpers.AssertParserHelper;
import seedu.mtracker.commands.AddEtfCommand;
import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.ui.TextUi;

public class AddEtfParser extends AddInstrumentParser {

    public static String INSTRUMENT_TYPE = "etf";

    private static final double UNDEFINED_PAST_RETURN_VALUE = -101;

    public String getEtfRemarkFromUser() {
        TextUi.displayAddRemarksInstruction();
        return getUserInput();
    }

    public String getEtfPastReturnFromUser() {
        TextUi.displayAddPastReturnsInstruction();
        return isValidPastReturn(getUserInput());
    }

    public static String isValidPastReturn(String userInput) {
        double pastReturn;
        try {
            pastReturn = Double.parseDouble(userInput);
        } catch (NumberFormatException e) {
            logger.info(LogHelper.LOG_EMPTY_PAST_RETURNS);
            pastReturn = UNDEFINED_PAST_RETURN_VALUE;
        }
        return String.valueOf(pastReturn);
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
