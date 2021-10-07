package seedu.mtracker.console;

import seedu.mtracker.commands.AddCryptoCommand;
import seedu.mtracker.commands.Command;

public class AddCryptoParser extends AddInstrumentParser {

    @Override
    public Command getInstrumentParameters() {
        return new AddCryptoCommand();
    }
}
