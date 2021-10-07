package seedu.mtracker.console;

import seedu.mtracker.commands.AddForexCommand;
import seedu.mtracker.commands.AddInstrumentCommand;

public class AddForexParser extends AddInstrumentParser {

    @Override
    public AddInstrumentCommand getInstrumentParameters() {
        return new AddForexCommand();
    }
}
