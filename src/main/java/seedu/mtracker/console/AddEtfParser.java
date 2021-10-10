package seedu.mtracker.console;

import seedu.mtracker.commands.AddEtfCommand;
import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.error.ErrorMessage;
import seedu.mtracker.ui.TextUi;

public class AddEtfParser extends AddInstrumentParser {

    public static String INSTRUMENT_TYPE = "etf";

    public String getEtfRemarksFromUser() {
        TextUi.displayAddRemarksInstruction();
        return getUserInput();
    }

    public String getEtfpastReturnsFromUser() {
        TextUi.displayAddPastReturnsInstruction();
        return getUserInput();
    }

    public static boolean isValidPastReturn(String pastReturns) {
        boolean isValid = true;
        try {
            Double.parseDouble(pastReturns);
        } catch (NumberFormatException e) {
            ErrorMessage.displayAddInstrumentCurrentPriceError();
            isValid = false;
        }
        return isValid;
    }

    public void addEtfRemarksToParameters() {
        String remarks = getEtfRemarksFromUser();
        parameters.add(remarks);
    }

    public void addEtfpastReturnsToParameters() {
        String pastReturns = getEtfpastReturnsFromUser();
        while (!isValidPastReturn(pastReturns)) {
            pastReturns = getEtfpastReturnsFromUser();
        }
        parameters.add(pastReturns);
    }

    public void getEtfSpecificParameters() {
        addEtfpastReturnsToParameters();
        addEtfRemarksToParameters();
    }

    @Override
    public AddInstrumentCommand getInstrumentParameters() {
        getGeneralParameters(INSTRUMENT_TYPE);
        getEtfSpecificParameters();
        return new AddEtfCommand();
    }
}
