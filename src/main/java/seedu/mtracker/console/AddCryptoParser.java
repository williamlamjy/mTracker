package seedu.mtracker.console;

import seedu.mtracker.commands.AddCryptoCommand;
import seedu.mtracker.commands.AddInstrumentCommand;

public class AddCryptoParser extends AddInstrumentParser {

    @Override
    public AddInstrumentCommand getInstrumentParameters() {
        return new AddCryptoCommand();
    }
}
