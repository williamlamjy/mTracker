package seedu.mtracker.console;

import seedu.mtracker.commands.AddHelpCommand;
import seedu.mtracker.commands.AddInstrumentCommand;

public class AddInvalidInstrumentParser extends AddInstrumentParser {
    @Override
    public AddInstrumentCommand getInstrumentParameters() {
        return new AddHelpCommand();
    }
}
