package seedu.mtracker.console;

import seedu.mtracker.commands.AddEtfCommand;
import seedu.mtracker.commands.AddInstrumentCommand;

public class AddEtfParser extends AddInstrumentParser {

    @Override
    public AddInstrumentCommand getInstrumentParameters() {
        return new AddEtfCommand();
    }
}
