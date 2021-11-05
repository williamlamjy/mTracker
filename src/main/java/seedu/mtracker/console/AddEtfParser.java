package seedu.mtracker.console;

import seedu.mtracker.asserthelpers.AssertParserHelper;
import seedu.mtracker.commands.AddEtfCommand;
import seedu.mtracker.commons.Validate;
import seedu.mtracker.commons.error.OperationAbortedError;
import seedu.mtracker.ui.TextUi;

public class AddEtfParser extends AddInstrumentParser {

    public static String INSTRUMENT_TYPE = "etf";
    public static final double UNDEFINED_PAST_RETURN_VALUE = -101;

    public String getEtfRemarkFromUser() {
        TextUi.displayAddRemarksInstruction();
        return getUserInput(WORKSPACE);
    }

    public String getEtfPastReturnFromUser() throws OperationAbortedError {
        TextUi.displayAddPastReturnsInstruction();
        String userInput = getUserInput(WORKSPACE);
        checkIfAbort(userInput, WORKSPACE);
        if (!Validate.isValidPastReturns(userInput)) {
            return String.valueOf(UNDEFINED_PAST_RETURN_VALUE);
        }
        return userInput;
    }

    public void addEtfRemarkToParameters() throws OperationAbortedError {
        String remarks = getEtfRemarkFromUser();
        checkIfAbort(remarks, WORKSPACE);
        parameters.add(remarks);
    }

    public void addEtfPastReturnToParameters() throws OperationAbortedError {
        String pastReturns = getEtfPastReturnFromUser();
        parameters.add(pastReturns);
    }

    public void getEtfSpecificParameters() throws OperationAbortedError {
        addEtfPastReturnToParameters();
        addEtfRemarkToParameters();
    }

    @Override
    public AddEtfCommand getInstrumentParameters() throws OperationAbortedError {
        getGeneralParameters(INSTRUMENT_TYPE);
        getEtfSpecificParameters();
        AssertParserHelper.assertNoMissingEtfParameters(parameters);
        return new AddEtfCommand();
    }
}
