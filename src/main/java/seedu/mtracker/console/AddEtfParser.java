package seedu.mtracker.console;

import seedu.mtracker.commands.AddEtfCommand;
import seedu.mtracker.commands.AddInstrumentCommand;
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

    public void addEtfRemarksToParameters() {
        String remarks = getEtfRemarksFromUser();
        parameters.add(remarks);
    }

    public void addEtfpastReturnsToParameters() {
        String pastReturns = getEtfpastReturnsFromUser();
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
