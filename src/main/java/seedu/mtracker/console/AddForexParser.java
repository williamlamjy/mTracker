package seedu.mtracker.console;

import seedu.mtracker.commands.AddForexCommand;
import seedu.mtracker.commands.Command;

public class AddForexParser extends AddInstrumentParser {

    @Override
    public Command getInstrumentParameters() {
        return new AddForexCommand();
    }
}
