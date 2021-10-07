package seedu.mtracker.console;

import seedu.mtracker.commands.AddEtfCommand;
import seedu.mtracker.commands.Command;

public class AddEtfParser extends AddInstrumentParser {

    @Override
    public Command getInstrumentParameters() {
        return new AddEtfCommand();
    }
}
