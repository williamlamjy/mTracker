package seedu.mtracker.console;

import seedu.mtracker.commands.AddHelpCommand;
import seedu.mtracker.commands.Command;

public class AddInvalidInstrumentParser extends AddInstrumentParser {
    @Override
    public Command getInstrumentParameters() {
        return new AddHelpCommand();
    }
}
