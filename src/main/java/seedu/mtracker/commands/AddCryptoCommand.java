package seedu.mtracker.commands;

public class AddCryptoCommand extends AddInstrumentCommand {

    public static final String COMMAND_WORD = "crypto";

    @Override
    public String execute() {
        return COMMAND_WORD;
    }
}
