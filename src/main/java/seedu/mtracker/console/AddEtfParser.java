package seedu.mtracker.console;

import seedu.mtracker.asserthelpers.AssertParserHelper;
import seedu.mtracker.commands.AddEtfCommand;
import seedu.mtracker.commons.Validate;
import seedu.mtracker.commons.error.OperationAbortedError;
import seedu.mtracker.ui.TextUi;

/**
 * A class responsible for parsing inputs when user is adding a new etf instrument.
 */
public class AddEtfParser extends AddInstrumentParser {

    public static String INSTRUMENT_TYPE = "etf";
    public static final double UNDEFINED_PAST_RETURN_VALUE = -101;

    /**
     * Queries and gets etf remarks from the user.
     *
     * @return User remarks input.
     */
    public String getEtfRemarkFromUser() {
        TextUi.displayAddRemarksInstruction();
        return getUserInput(WORKSPACE);
    }

    /**
     * Queries and gets etf past returns from the user.
     *
     * @return User past returns input.
     * @throws OperationAbortedError If the user wants to abort the add etf process.
     */
    public String getEtfPastReturnFromUser() throws OperationAbortedError {
        TextUi.displayAddPastReturnsInstruction();
        String userInput = getUserInput(WORKSPACE);
        checkIfAbort(userInput, WORKSPACE);
        if (!Validate.isValidPastReturns(userInput)) {
            return String.valueOf(UNDEFINED_PAST_RETURN_VALUE);
        }
        return userInput;
    }

    /**
     * Gets the user etf remarks input and adds it into the parameters list.
     *
     * @throws OperationAbortedError If the user wants to abort the add etf process.
     */
    public void addEtfRemarkToParameters() throws OperationAbortedError {
        String remarks = getEtfRemarkFromUser();
        checkIfAbort(remarks, WORKSPACE);
        parameters.add(remarks);
    }

    /**
     * Gets the user etf past returns input and adds it into the parameters list.
     *
     * @throws OperationAbortedError If the user wants to abort the add etf process.
     */
    public void addEtfPastReturnToParameters() throws OperationAbortedError {
        String pastReturns = getEtfPastReturnFromUser();
        parameters.add(pastReturns);
    }

    /**
     * Gets etf specific parameters from the user when adding a new etf instrument.
     *
     * @throws OperationAbortedError If the user wants to abort the add etf process.
     */
    public void getEtfSpecificParameters() throws OperationAbortedError {
        addEtfPastReturnToParameters();
        addEtfRemarkToParameters();
    }

    /**
     * Gets from the user all parameters needed to create a new etf instrument.
     *
     * @return A command for adding a new etf.
     * @throws OperationAbortedError If the user wants to abort the add etf process.
     */
    @Override
    public AddEtfCommand getInstrumentParameters() throws OperationAbortedError {
        getGeneralParameters(INSTRUMENT_TYPE);
        getEtfSpecificParameters();
        AssertParserHelper.assertNoMissingEtfParameters(parameters);
        return new AddEtfCommand();
    }
}
